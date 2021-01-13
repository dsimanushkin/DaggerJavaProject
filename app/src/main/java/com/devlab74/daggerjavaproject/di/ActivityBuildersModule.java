package com.devlab74.daggerjavaproject.di;

import com.devlab74.daggerjavaproject.di.auth.AuthModule;
import com.devlab74.daggerjavaproject.di.auth.AuthViewModelsModule;
import com.devlab74.daggerjavaproject.di.main.MainFragmentBuildersModule;
import com.devlab74.daggerjavaproject.ui.auth.AuthActivity;
import com.devlab74.daggerjavaproject.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

}
