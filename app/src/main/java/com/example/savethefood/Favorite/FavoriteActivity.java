package com.example.savethefood.Favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;
import com.example.savethefood.Recipe.RecipeActivity;
import com.example.savethefood.Recipe.RecipeListAdapter;
import com.example.savethefood.Recipe.SingleRecipeActivity;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.savethefood.Recipe.SingleRecipeActivity.EXTRA_Single_Recipe;

public class FavoriteActivity extends AppCompatActivity implements RecipeListAdapter.OnNodeListener {

    public static String EXTRA_RECIPES_LOCAL = "com.example.FavoriteActivity.RecieveRecipesOnLocalMachine";

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mRecipesListAdapter;

    private ArrayList<Recipe> recipes = new ArrayList<>();


    TextView mPretext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        mRecyclerView = findViewById(R.id.recyclerview);
        mPretext = findViewById(R.id.textView_PreText);
        receiveIntent();
        InitializeAdapter();
    }

    private void InitializeAdapter() {
        mRecipesListAdapter = new RecipeListAdapter(this, recipes, FavoriteActivity.this::onNodeClick);
        mRecyclerView.setAdapter(mRecipesListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPretext.setVisibility(View.INVISIBLE);
    }

    private void receiveIntent()
    {
        Bundle bundle = getIntent().getExtras();
        recipes = bundle.getParcelableArrayList(EXTRA_RECIPES_LOCAL);
    }


    @Override
    public void onNodeClick(int position) {
        Intent intent = new Intent(this, SingleFavoriteActivity.class);
        intent.putExtra(SingleFavoriteActivity.EXTRA_Single_Recipe_Local, recipes.get(position));
        startActivity(intent);
    }
}