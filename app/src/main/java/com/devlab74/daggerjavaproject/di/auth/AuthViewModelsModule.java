package com.devlab74.daggerjavaproject.di.auth;

import androidx.lifecycle.ViewModel;

import com.devlab74.daggerjavaproject.di.ViewModelKey;
import com.devlab74.daggerjavaproject.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}
