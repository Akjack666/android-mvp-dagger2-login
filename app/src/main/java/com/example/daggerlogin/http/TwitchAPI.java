package com.example.daggerlogin.http;

import com.example.daggerlogin.http.twitch.Twich;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TwitchAPI {

    @GET("games/top")
    Call <Twich> getTopGames(@Header("client-id") String clientId);
}
