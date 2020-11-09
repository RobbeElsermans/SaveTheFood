package com.example.savethefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class getRecipeInfo extends AppCompatActivity {

    public final static String EXTRA_Recieve_SearchKey = "com.example.Scanner.ReceiveSearchKey";
    private String app_ID = "c4d00532";
    private String app_key = "025c0351897d2cd9fa6ea959a263f93b";
    private String msearchKey;

    private Intent getSearchKey;

    EDAMAMAPI APIrecipe;
    TextView mrecipe;
    String mkeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_recipe_info);

        mrecipe = findViewById(R.id.search_Results);

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

            retrieveInfo();
        }
        else
        {
            mrecipe.setText("Invalid input");
        }
    }

    private boolean isEmpty(String text) {
        if (text.trim().length() > 0)
            return false;

        return true;
    }

    public void retrieveInfo(){
        String url = "search?app_id="+app_ID+"&app_key="+app_key+"&q="+mkeyword;
        Call<RecipeInfo> call = APIrecipe.getPosts(url);

        call.enqueue(new Callback<RecipeInfo>() {
            @Override
            public void onResponse(Call<RecipeInfo> call, Response<RecipeInfo> response) {
                if (response.isSuccessful())
                {

                    RecipeInfo recipeInfo = response.body();

                    String message = "";

                    message +=  recipeInfo.getMore() + "\n";

                    for (int i = 0; i < recipeInfo.getHits().size(); i++)
                    {
                        message += recipeInfo.getHits().get(i).getRecept().getLabel().toString() + "\n";
                    }

                    mrecipe.setText(message);
                }
                else
                {
                    Log.d("MainFail","Niet Succesfull" +response.code());
                }
            }

            @Override
            public void onFailure(Call<RecipeInfo> call, Throwable t) {
                Log.d("MainFail","Niet gelukt" + t.getMessage());
            }
        });
    }
}