package com.example.savethefood.Recipe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListHolder> {

    private LinkedList<Recipe> mRecipeList = new LinkedList<Recipe>();
    private LayoutInflater mInflater;
    private Context context;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecipeListAdapter.RecipeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item, parent, false);

        final RecipeListAdapter.RecipeListHolder viewHolder = new RecipeListAdapter.RecipeListHolder(mItemView);
        viewHolder.item_container.setOnClickListener(v -> Log.e("TEST", mRecipeList.get(viewHolder.getAdapterPosition()).getLabel())
        );
        return viewHolder;
    }

    //Het plaatsen van data
    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeListHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.recipeTitle.setText(mCurrent.getLabel());
        Glide.with(context).load(mCurrent.getUri()).into(holder.recipeUrl);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeListHolder extends RecyclerView.ViewHolder {
        public final ImageView recipeUrl;
        public final TextView recipeTitle;
        public final LinearLayout item_container;

        public RecipeListHolder(@NonNull View itemView) {
            super(itemView);
            recipeTitle = itemView.findViewById(R.id.textview_recipe_title);
            recipeUrl = itemView.findViewById(R.id.imageView_recipe_image);
            item_container = itemView.findViewById(R.id.lineairLayout_recipes);
        }
    }

}
