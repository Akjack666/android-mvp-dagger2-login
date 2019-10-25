package com.example.daggerlogin.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daggerlogin.R;

import javax.inject.Inject;

import dagger.Module;

@Module
public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
