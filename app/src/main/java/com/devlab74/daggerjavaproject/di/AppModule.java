package com.devlab74.daggerjavaproject.di;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static String someString() {
        return "This is a test String";
    }

    @Provides
    static boolean getApp(Application application) {
        return application == null;
    }

}
