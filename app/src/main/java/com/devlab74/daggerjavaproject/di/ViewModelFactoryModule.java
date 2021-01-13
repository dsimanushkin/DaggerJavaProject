package com.devlab74.daggerjavaproject.di;

import androidx.lifecycle.ViewModelProvider;

import com.devlab74.daggerjavaproject.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

}
