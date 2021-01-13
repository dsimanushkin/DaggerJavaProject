package com.devlab74.daggerjavaproject.di.main;

import com.devlab74.daggerjavaproject.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

}
