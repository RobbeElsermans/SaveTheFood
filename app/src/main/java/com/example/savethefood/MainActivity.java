package com.example.savethefood;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.savethefood.Recipe.RecipeActivity;
import com.example.savethefood.Scanner.ScannerActivity;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static int AmountSearchRecipes;
    private Intent cameraScan;
    private Intent searchRecipe;

    private int CAMERA_PERM = 0;
    private int INTERNET_PERM = 1;

    private EditText searchKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraScan = new Intent(this, ScannerActivity.class);
        searchRecipe = new Intent(this, RecipeActivity.class);

        searchKey = findViewById(R.id.search_bar_item);

        if (!isOnline(this))
            Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_LONG).show();
        setupSharedPreferences();
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(sharedPreferences, "amount_recipes");
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        String preference = "";
        if (key.equals("amount_recipes")) {
            preference = sharedPreferences.getString("amount_recipes", "search_2");
        }

        switch (preference) {
            case "search_2":
                AmountSearchRecipes = 2;
                break;
            case "search_5":
                AmountSearchRecipes = 5;
                break;
            case "search_10":
                AmountSearchRecipes = 10;
                break;
            case "search_20":
                AmountSearchRecipes = 20;
                break;
            case "search_40":
                AmountSearchRecipes = 40;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static boolean isOnline(Context context) {
        return NetworkCheck.getInstance(context).isOnline();
    }

    public void scan(View view) {
        //BRON: https://blog.mindorks.com/implementing-easy-permissions-in-android-android-tutorial
        if (hasPermissionCamera())
            startActivity(cameraScan);
        else
            EasyPermissions.requestPermissions(this, getString(R.string.camera_permission), CAMERA_PERM, Manifest.permission.CAMERA);
    }

    private boolean hasPermissionCamera() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA);
    }

    private boolean hasPermissionInternet() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.INTERNET);
    }

    public void searchRecipe(View view) {
        if (hasPermissionInternet()) {
            if (!isEmpty(searchKey)) {
                searchRecipe.putExtra(RecipeActivity.EXTRA_Recieve_SearchKey, searchKey.getText().toString());
                startActivity(searchRecipe);
            } else Toast.makeText(this, R.string.no_search_key, Toast.LENGTH_SHORT).show();
        } else
            EasyPermissions.requestPermissions(this, getString(R.string.internet_permission), INTERNET_PERM, Manifest.permission.INTERNET);
    }

    public void favorite(View view) {
    }

    //bron: https://stackoverflow.com/questions/6290531/check-if-edittext-is-empty
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() <= 0;
    }

    public void goToSite(View view) {
        Uri pagina = null;
        if (view.getId() == R.id.imgview_edamam)
            pagina = Uri.parse(getResources().getString(R.string.url_edamam));

        if (view.getId() == R.id.imgview_openFoodFacts)
            pagina = Uri.parse(getResources().getString(R.string.url_openfoodfacts));

        if (pagina != null) {
            Intent send = new Intent(Intent.ACTION_VIEW, pagina);
            if (send.resolveActivity(getPackageManager()) != null)
                startActivity(send);
            else
                Toast.makeText(this, R.string.no_valid_browser, Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}