package com.example.daggerlogin.main;

public interface MainActivityMVP {


    interface View {


    }

    interface Presenter {

       void setView (MainActivityMVP.View view);
       void showToast();

    }

    interface Model {


    }
}
