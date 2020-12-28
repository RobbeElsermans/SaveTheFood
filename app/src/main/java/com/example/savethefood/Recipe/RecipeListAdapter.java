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
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListHolder> {

    private ArrayList<Recipe> mRecipeList;
    private Recipe mDeletedRecipe;
    private int mDeletedRecipePosition;

    private LayoutInflater mInflater;
    private Context context;
    private OnNodeListener mOnNodeListener;
    private View mRootview;

    public RecipeListAdapter(Context context, ArrayList<Recipe> recipeList, OnNodeListener onNodeListener, View mRootView) {
        mInflater = LayoutInflater.from(context);
        this.mRecipeList = recipeList;
        this.context = context;
        this.mOnNodeListener = onNodeListener;
        this.mRootview = mRootView;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_item, parent, false);

        return new RecipeListHolder(mItemView, mOnNodeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeListHolder holder, int position) {
        Recipe mCurrentRecipe = mRecipeList.get(position);

        holder.mRecipeTitle.setText(mCurrentRecipe.getLabel());

        String text = "";
        text += mCurrentRecipe.getIngredientLines().length + " Ingredients";
        holder.mRecipeSubTitle.setText(text);

        text = (int)mCurrentRecipe.getPrepTime() + " minutes";
        holder.mRecipePreparationTime.setText(text);

        text = (int)mCurrentRecipe.getCalories() + " kcal";
        holder.mRecipeCalories.setText(text);

        Glide.with(context).load(mCurrentRecipe.getImage()).into(holder.mRecipeUrl);
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class RecipeListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final ImageView mRecipeUrl;
        public final TextView mRecipeTitle;
        public final TextView mRecipeSubTitle;
        public final TextView mRecipePreparationTime;
        public final TextView mRecipeCalories;
        OnNodeListener onNodeListener;

        public RecipeListHolder(@NonNull View itemView, OnNodeListener onNodeListener) {
            super(itemView);
            mRecipeTitle = itemView.findViewById(R.id.textview_recipe_title);
            mRecipeUrl = itemView.findViewById(R.id.imageView_recipe_image);
            mRecipeSubTitle = itemView.findViewById(R.id.textview_recipe_description);
            mRecipePreparationTime = itemView.findViewById(R.id.textview_recipe_preperation);
            mRecipeCalories = itemView.findViewById(R.id.textview_recipe_calories);
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

    public void deleteItem(int position) {
        mDeletedRecipe = mRecipeList.get(position);
        mDeletedRecipePosition = position;
        mRecipeList.remove(position);
        notifyItemRemoved(position);
        showUndoSnackbar();
    }

    private void showUndoSnackbar() {
        //View view = View.findViewById(R.id.coordinator_layout);
        Snackbar snackbar = Snackbar.make(mRootview, R.string.snack_bar_text, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
        snackbar.setAction(R.string.snack_bar_undo, v -> undoDelete());
        snackbar.show();
    }

    private void undoDelete() {
        mRecipeList.add(mDeletedRecipePosition, mDeletedRecipe);
        notifyItemInserted(mDeletedRecipePosition);
    }
}
