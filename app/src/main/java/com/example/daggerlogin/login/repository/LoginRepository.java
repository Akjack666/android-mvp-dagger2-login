package com.example.daggerlogin.login.repository;

import com.example.daggerlogin.login.model.User;

public interface LoginRepository {

    void saveUser(User user);

    User getUser();
}
