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

import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;
import com.example.savethefood.Recipe.Model.RecipeInfo;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeActivity extends AppCompatActivity {

    public final static String EXTRA_Recieve_SearchKey = "com.example.Scanner.ReceiveSearchKey";
    private String app_ID = "c4d00532";
    private String app_key = "025c0351897d2cd9fa6ea959a263f93b";
    private String msearchKey;

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mRecipesListAdapter;

    private LinkedList<Recipe> recipes = new LinkedList<>();
    private Intent getSearchKey;

    EDAMAMAPI APIrecipe;
    TextView mPretext;
    String mkeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        //Recycler aanmaken
        mRecyclerView = findViewById(R.id.recyclerview);
        mPretext = findViewById(R.id.textView_PreText);
        //Intent ontvangen van een andere activity
        getSearchKey = getIntent();

        //kijken of de extra key wel bestaat.
        if (!isEmpty(getSearchKey.getStringExtra(EXTRA_Recieve_SearchKey)))
        {
            mkeyword = getSearchKey.getStringExtra(EXTRA_Recieve_SearchKey);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.edamam.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIrecipe = retrofit.create(EDAMAMAPI.class);

            retrieveInfo(this);
        }
        else
        {

        }
    }

    private boolean isEmpty(String text) {
        if (text.trim().length() > 0)
            return false;

        return true;
    }

    public void retrieveInfo(RecipeActivity getRecipeInfo){
        String url = "search?app_id="+app_ID+"&app_key="+app_key+"&q="+mkeyword+"&to=2";
        Call<RecipeInfo> call = APIrecipe.getPosts(url);

        call.enqueue(new Callback<RecipeInfo>() {
            @Override
            public void onResponse(Call<RecipeInfo> call, Response<RecipeInfo> response) {
                if (response.body().getCount() > 0)
                {
                    mPretext.setVisibility(View.GONE);
                    RecipeInfo recipeInfo = response.body();

                    for (int i = 0; i < recipeInfo.getHits().size(); i++)
                    {
                        recipes.addLast(recipeInfo.getHits().get(i).getRecept());
                    }

                    mRecipesListAdapter = new RecipeListAdapter(getRecipeInfo, recipes);
                    mRecyclerView.setAdapter(mRecipesListAdapter);
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getRecipeInfo));
                }
                else
                {
                    Log.d("MainFail","Niet Succesfull" +response.code());
                    Toast.makeText(RecipeActivity.this, "not found in database!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<RecipeInfo> call, Throwable t) {
                Log.d("MainFail","Niet gelukt" + t.getMessage());
            }
        });
    }
}