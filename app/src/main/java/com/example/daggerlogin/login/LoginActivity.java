package com.example.daggerlogin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daggerlogin.R;
import com.example.daggerlogin.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    EditText etName, etLastName;
    Button btEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        etName = findViewById(R.id.et_name);
        etLastName = findViewById(R.id.et_last_name);
        btEnter = findViewById(R.id.bt_enter);

        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked(getApplicationContext());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();

    }

    @Override
    public String getName() {
        return this.etName.getText().toString();
    }

    @Override
    public String getLastName() {
        return this.etLastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "El usuario no esta disponible", Toast.LENGTH_LONG).show();

    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Error, algun campo esta vacio", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSaved() {
        Toast.makeText(this, "Usuario guardado correctamente", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setName(String name) {
        this.etName.setText(name);

    }

    @Override
    public void setLastName(String lastName) {
        this.etLastName.setText(lastName);
    }




}
