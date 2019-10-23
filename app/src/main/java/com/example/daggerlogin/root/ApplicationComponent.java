package com.example.daggerlogin.root;

import com.example.daggerlogin.http.TwitchModule;
import com.example.daggerlogin.login.LoginActivity;
import com.example.daggerlogin.login.LoginModule;

import dagger.Component;


@Component(modules = {AplicationModule.class, LoginModule.class, TwitchModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);
}
