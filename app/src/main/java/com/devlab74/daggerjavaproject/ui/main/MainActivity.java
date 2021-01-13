package com.devlab74.daggerjavaproject.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.devlab74.daggerjavaproject.BaseActivity;
import com.devlab74.daggerjavaproject.R;
import com.devlab74.daggerjavaproject.ui.main.posts.PostsFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testFragment();
    }

    private void testFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new PostsFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            sessionManager.logOut();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
