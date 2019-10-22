package com.example.daggerlogin.root;

import android.app.Application;

import com.example.daggerlogin.login.repository.MemoryRepository;


public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .aplicationModule(new AplicationModule(this))
                .loginModule(new MemoryRepository.LoginModule())
                .build();
    }

    public ApplicationComponent getComponent () {
        return component;
    }
}
