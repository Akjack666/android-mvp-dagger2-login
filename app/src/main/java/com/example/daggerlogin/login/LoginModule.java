package com.example.daggerlogin.login;

import com.example.daggerlogin.login.repository.LoginRepository;
import com.example.daggerlogin.login.repository.MemoryRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

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