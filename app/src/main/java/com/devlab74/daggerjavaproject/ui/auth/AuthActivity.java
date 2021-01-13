package com.devlab74.daggerjavaproject.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.devlab74.daggerjavaproject.R;
import com.devlab74.daggerjavaproject.models.User;
import com.devlab74.daggerjavaproject.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AuthActivity";

    private AuthViewModel viewModel;
    private EditText userId;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        viewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);

        userId = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);

        setLogo();
        subscribeObservers();
    }

    private void setLogo() {
        requestManager.load(logo).into((ImageView) findViewById(R.id.login_logo));
    }

    private void subscribeObservers() {
        viewModel.observeUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    Log.d(TAG, "onChanged: " + user.getEmail());
                }
            }
        });
    }

    private void attemptLogin() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        } else {
            viewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
            attemptLogin();
        }
    }
}