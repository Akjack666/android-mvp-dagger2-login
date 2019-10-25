package com.example.daggerlogin.main;

import com.example.daggerlogin.main.repository.MainRepository;
import com.example.daggerlogin.main.repository.MemoryRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainActivityMVP.Presenter provideLoginActivityPresenter(MainActivityMVP.Model model) {
        return new MainActivityPresenter(model);
    }

    @Provides
    public MainActivityMVP.Model providerLoginActivityModel(MainRepository repository) {
        return new MainActivityModel(repository);
    }

    @Provides
    public MainRepository provideMainRepository() {
        return new MemoryRepository(); // Cambiamos aqui , dependiendo donde tengamos el repositorio
    }
}
