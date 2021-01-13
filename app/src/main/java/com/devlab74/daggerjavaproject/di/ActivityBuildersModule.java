package com.devlab74.daggerjavaproject.di;

import com.devlab74.daggerjavaproject.di.auth.AuthModule;
import com.devlab74.daggerjavaproject.di.auth.AuthScope;
import com.devlab74.daggerjavaproject.di.auth.AuthViewModelsModule;
import com.devlab74.daggerjavaproject.di.main.MainFragmentBuildersModule;
import com.devlab74.daggerjavaproject.di.main.MainModule;
import com.devlab74.daggerjavaproject.di.main.MainScope;
import com.devlab74.daggerjavaproject.di.main.MainViewModelsModule;
import com.devlab74.daggerjavaproject.ui.auth.AuthActivity;
import com.devlab74.daggerjavaproject.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

}
