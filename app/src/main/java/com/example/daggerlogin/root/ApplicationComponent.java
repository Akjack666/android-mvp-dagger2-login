package com.example.daggerlogin.root;

import com.example.daggerlogin.login.LoginActivity;
import com.example.daggerlogin.login.repository.MemoryRepository;

import dagger.Component;


@Component(modules = {AplicationModule.class, MemoryRepository.LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity targer);
}
