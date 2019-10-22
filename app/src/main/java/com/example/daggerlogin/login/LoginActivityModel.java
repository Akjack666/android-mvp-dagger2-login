package com.example.daggerlogin.login;

import com.example.daggerlogin.login.model.User;
import com.example.daggerlogin.login.repository.LoginRepository;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository repository;
    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }


    @Override
    public void createUser(String name, String lastName) {
        // logica de bussines
        repository.saveUser(new User(name, lastName));
    }

    @Override
    public User getUser() {
        // Logica de bussines
        return repository.getUser();
    }
}
