package com.example.daggerlogin.login;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.example.daggerlogin.login.model.User;
import com.example.daggerlogin.main.MainActivity;
import com.example.daggerlogin.root.AplicationModule;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;

    }

    @Override
    public void loginButtonClicked(Context context) {
        if (view != null) {
            if (view.getName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getName().trim(), view.getLastName().trim());
                view.showUserSaved();
                goMain(context);

            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            if (view != null) {
                view.setName(user.getName());
                view.setLastName(user.getLastName());
            }
        }

    }


    private void goMain(Context context) {
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
}
