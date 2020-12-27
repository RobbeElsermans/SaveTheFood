package com.example.savethefood.Favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.savethefood.MainActivity;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;
import com.example.savethefood.Recipe.RecipeListAdapter;
import com.example.savethefood.SaveData.FileStream;
import com.example.savethefood.SaveData.jsonConverter;

import java.io.IOException;
import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity implements RecipeListAdapter.OnNodeListener {

    public static String EXTRA_RECIPES_LOCAL = "com.example.FavoriteActivity.RecieveRecipesOnLocalMachine";

    private RecyclerView mRecyclerView;
    private RecipeListAdapter mRecipesListAdapter;
    private ItemTouchHelper itemTouchHelper;

    private ArrayList<Recipe> recipes = new ArrayList<>();

    private com.example.savethefood.SaveData.jsonConverter jsonConverter;
    private FileStream fileStream;


    TextView mPretext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        mRecyclerView = findViewById(R.id.recyclerview);
        mPretext = findViewById(R.id.textView_PreText);

        jsonConverter = new jsonConverter();
        fileStream = new FileStream(MainActivity.FAVORITE_FILE_NAME, this);

        receiveIntent();
        InitializeAdapter();
    }

    private void InitializeAdapter() {
        mRecipesListAdapter = new RecipeListAdapter(this, recipes, FavoriteActivity.this::onNodeClick, findViewById(R.id.favorites_root_view));
        mRecyclerView.setAdapter(mRecipesListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPretext.setVisibility(View.INVISIBLE);
        itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(mRecipesListAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String text;
        if (recipes.size() != 0) {
            text = jsonConverter.ArrayToStringConverter(recipes);
        }
        else text = "";
        fileStream.writeNewRecipesToFile(text);
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