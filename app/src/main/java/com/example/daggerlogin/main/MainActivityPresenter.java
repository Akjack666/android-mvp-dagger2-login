package com.example.daggerlogin.main;

import androidx.annotation.Nullable;

public class MainActivityPresenter implements MainActivityMVP.Presenter {


    @Nullable
    private MainActivityMVP.Model model;
    private MainActivityMVP.View view;

    public MainActivityPresenter(MainActivityMVP.Model model) {
        this.model = model;
    }


    @Override
    public void setView(MainActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void showToast() {

    }
}
