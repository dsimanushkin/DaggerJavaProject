package com.devlab74.daggerjavaproject.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.devlab74.daggerjavaproject.BaseActivity;
import com.devlab74.daggerjavaproject.R;
import com.devlab74.daggerjavaproject.ui.main.posts.PostsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        init();
    }

    private void init() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);
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
        } else if (item.getItemId() == R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            } else {
                return false;
            }
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile: {

                NavOptions navOptions = new NavOptions
                        .Builder()
                        .setPopUpTo(R.id.main, true)
                        .build();

                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.profileScreen, null, navOptions);
                break;
            }
            case R.id.nav_posts: {

                if (isValidDestination(R.id.postsScreen)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.postsScreen);
                }

                break;
            }
        }

        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isValidDestination(int destination) {
        return destination != Navigation.findNavController(this, R.id.nav_host_fragment).getCurrentDestination().getId();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.nav_host_fragment), drawerLayout);
    }
}
