package com.ece452.watfit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SharedWithMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_with_me);

        // set back button in top-left corner
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back_arrow);
        }

        // TODO: Dynamically display post preview cards if there is at least 1 privately shared post by friend

    }

    // Button action when a post preview card is clicked
    // nav to the screen where post content is displayed
    public void navigateToPostViewActivity(View view) {
        startActivity(new Intent(SharedWithMeActivity.this, PostContentActivity.class));
    }

    // nav to AccountActivity when back button is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the back button click
            startActivity(new Intent(SharedWithMeActivity.this, AccountActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}