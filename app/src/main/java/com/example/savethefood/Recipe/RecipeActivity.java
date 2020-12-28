package com.example.savethefood.Recipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.savethefood.GlobalUse.Toaster;
import com.example.savethefood.MainActivity;
import com.example.savethefood.GlobalUse.NetworkCheck;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;
import com.example.savethefood.Recipe.Model.RecipeInfo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.savethefood.Recipe.SingleRecipeActivity.EXTRA_Single_Recipe;

public class RecipeActivity extends AppCompatActivity implements RecipeListAdapter.OnNodeListener {

    public final static String EXTRA_Recieve_SearchKey = "com.example.Scanner.ReceiveSearchKey";
    private String app_ID = "c4d00532";
    private String app_key = "025c0351897d2cd9fa6ea959a263f93b";
    private int mAmountSearch;
    private Toaster mToaster;

    private int mTryReconnect = 1;

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mRecipesListAdapter;

    private ArrayList<Recipe> recipes = new ArrayList<>();
    private Intent getSearchKey;

    EDAMAMAPI APIrecipe;
    TextView mPretext;
    String mkeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        mToaster = new Toaster(this);

        //Intent ontvangen van een andere activity
        getSearchKey = getIntent();

        //kijken of de extra key wel bestaat.
        mkeyword = getSearchKey.getStringExtra(EXTRA_Recieve_SearchKey);

        if (mkeyword.isEmpty() && mkeyword != null)
        {
            mToaster.shortToast(getString(R.string.no_search_key));
            finish();
        }

        if (MainActivity.isOnline(this))
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.url_api_edamam))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIrecipe = retrofit.create(EDAMAMAPI.class);

            retrieveInfo(this);
        }
        else
        {
            mToaster.longToast(getString(R.string.no_internet_connection));
            finish();
        }

        //Recycler aanmaken
        mRecyclerView = findViewById(R.id.recyclerview);
        mPretext = findViewById(R.id.textView_PreText);
    }

    public void retrieveInfo(RecipeActivity activity){
        String url = "search?app_id="+app_ID+"&app_key="+app_key+"&q="+mkeyword+"&to=" + MainActivity.AmountSearchRecipes;
        Call<RecipeInfo> call = APIrecipe.getPosts(url);

            call.enqueue(new Callback<RecipeInfo>() {
                @Override
                public void onResponse(@NotNull Call<RecipeInfo> call, @NotNull Response<RecipeInfo> response) {
                    if (response.body().getCount() > 0 && response.body() != null) {
                        mPretext.setVisibility(View.GONE);
                        RecipeInfo recipeInfo = response.body();

                        for (int i = 0; i < recipeInfo.getHits().size(); i++) {
                            recipes.add(recipeInfo.getHits().get(i).getRecept());
                        }

                        mRecipesListAdapter = new RecipeListAdapter(activity, recipes, RecipeActivity.this, null);
                        mRecyclerView.setAdapter(mRecipesListAdapter);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
                    } else {
                        mToaster.shortToast(getString(R.string.not_in_database));
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<RecipeInfo> call, Throwable t)
                {
                    Log.d(String.valueOf(RecipeActivity.this), R.string.not_responding_database + t.getMessage());

                    if (mTryReconnect > 0) {
                        mToaster.shortToast(getString(R.string.try_again_connecting));
                        mTryReconnect--;
                        retrieveInfo(RecipeActivity.this);
                    } else {
                        mToaster.shortToast(getString(R.string.not_responding_database));
                        finish();
                    }
                }
            });
    }


    @Override
    public void onNodeClick(int position) {
        Intent intent = new Intent(this, SingleRecipeActivity.class);
        intent.putExtra(EXTRA_Single_Recipe, recipes.get(position));
        startActivity(intent);
    }
}