package com.example.savethefood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListHolder> {

    private final LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
    }
    @NonNull
    @Override
    public RecipeListAdapter.RecipeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item, parent, false);
        return new RecipeListHolder(mItemView, this);
    }

    //Het plaatsen van data
    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeListHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.recipeTitle.setText(mCurrent.getLabel());
        holder.recipeUrl.setText(mCurrent.getUri());
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeListHolder extends RecyclerView.ViewHolder {
        public final TextView recipeUrl;
        public final TextView recipeTitle;

        final RecipeListAdapter mAdapter;

        public RecipeListHolder(@NonNull View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitle = itemView.findViewById(R.id.textview_recipe_title);
            recipeUrl = itemView.findViewById(R.id.textview_recipe_url);
            this.mAdapter = adapter;
        }
    }
}
