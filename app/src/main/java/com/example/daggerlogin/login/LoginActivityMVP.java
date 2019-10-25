package com.example.daggerlogin.login;

import android.content.Context;

import com.example.daggerlogin.login.model.User;

public interface LoginActivityMVP {


    interface View {

        String getName();

        String getLastName();

        void showUserNotAvailable();

        void showInputError();

        void showUserSaved();

        void setName(String name);

        void setLastName(String lastName);



    }


    interface Presenter {
        void setView(LoginActivityMVP.View view);

        void loginButtonClicked(Context context);

        void getCurrentUser();

    }

    interface Model {

        void createUser(String name, String lastName);

        User getUser();

    }


}
