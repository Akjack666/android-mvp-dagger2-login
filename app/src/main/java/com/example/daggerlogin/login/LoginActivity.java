package com.example.daggerlogin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daggerlogin.R;
import com.example.daggerlogin.http.TwitchAPI;
import com.example.daggerlogin.http.twitch.Game;
import com.example.daggerlogin.http.twitch.Twich;
import com.example.daggerlogin.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    @Inject
    TwitchAPI twitchAPI;

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
                presenter.loginButtonClicked();
            }
        });


        // Ejemplo del uso de la api de twitch

        Call<Twich> call = twitchAPI.getTopGames("3l81upzqs0q86nlheh781w4jpcx5a1");
        call.enqueue(new Callback<Twich>() {
            @Override
            public void onResponse(Call<Twich> call, Response<Twich> response) {
                List<Game> topGames = response.body().getData();

                for (Game game : topGames) {
                    System.out.println(game.getName());
                }
            }

            @Override
            public void onFailure(Call<Twich> call, Throwable t) {
                t.printStackTrace();
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
