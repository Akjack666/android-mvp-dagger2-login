package com.example.daggerlogin.main;

import com.example.daggerlogin.main.repository.MainRepository;

public class MainActivityModel implements MainActivityMVP.Model {

    MainRepository mainRepository;

    public  MainActivityModel (MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }
}
