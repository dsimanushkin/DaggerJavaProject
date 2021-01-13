package com.devlab74.daggerjavaproject.network.auth;

import com.devlab74.daggerjavaproject.models.User;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );

}
