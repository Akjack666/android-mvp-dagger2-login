package com.example.daggerlogin.root;

import com.example.daggerlogin.login.LoginActivity;
import com.example.daggerlogin.login.LoginModule;
import com.example.daggerlogin.main.MainActivity;

import dagger.Component;


@Component(modules = {AplicationModule.class, LoginModule.class, MainActivity.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
