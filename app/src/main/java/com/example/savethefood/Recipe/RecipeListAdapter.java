package com.example.savethefood.Recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.savethefood.R;
import com.example.savethefood.Recipe.Model.Recipe;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListHolder> {

    private LinkedList<Recipe> mRecipeList;
    private LayoutInflater mInflater;
    private Context context;
    private OnNodeListener mOnNodeListener;

    public RecipeListAdapter(Context context, LinkedList<Recipe> recipeList, OnNodeListener onNodeListener) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
        this.context = context;
        this.mOnNodeListener = onNodeListener;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item, parent, false);

        return new RecipeListHolder(mItemView, mOnNodeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeListHolder holder, int position) {
        Recipe mCurrent = mRecipeList.get(position);
        holder.recipeTitle.setText(mCurrent.getLabel());
        Glide.with(context).load(mCurrent.getImage()).into(holder.recipeUrl);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView recipeUrl;
        public final TextView recipeTitle;
        OnNodeListener onNodeListener;

        public RecipeListHolder(@NonNull View itemView, OnNodeListener onNodeListener) {
            super(itemView);
            recipeTitle = itemView.findViewById(R.id.textview_recipe_title);
            recipeUrl = itemView.findViewById(R.id.imageView_recipe_image);
            this.onNodeListener =   onNodeListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNodeListener.onNodeClick(getAdapterPosition());
        }
    }

    public interface OnNodeListener{
        void onNodeClick(int position);
    }
}
