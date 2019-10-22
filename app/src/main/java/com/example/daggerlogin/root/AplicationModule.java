package com.example.daggerlogin.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AplicationModule {

    private Application aplication;

    public AplicationModule(Application aplication) {
        this.aplication = aplication;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return aplication;
    }

}
