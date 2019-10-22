package com.example.daggerlogin.login.repository;

import com.example.daggerlogin.login.LoginActivityMVP;
import com.example.daggerlogin.login.LoginActivityModel;
import com.example.daggerlogin.login.LoginActivityPresenter;
import com.example.daggerlogin.login.model.User;

import dagger.Module;
import dagger.Provides;

public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public void saveUser(User user) {

        if(user == null) {
            user = getUser();
        }
        this.user = user;

    }

    @Override
    public User getUser() {
        if(user == null) {
            user = new User("Antonio", "Banderas");
            user.setId(0);
            return user;
        }else {
            return user;
        }
    }

    @Module
    public static class LoginModule {

        @Provides
        public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model) {
            return new LoginActivityPresenter(model);
        }

        @Provides
        public LoginActivityMVP.Model providerLoginActivityModel(LoginRepository repository) {
            return new LoginActivityModel(repository);
        }

        @Provides
        public LoginRepository provideLoginRepository() {
            return new MemoryRepository(); // Cambiamos aqui , dependiendo donde tengamos el repositorio
        }

    }
}
