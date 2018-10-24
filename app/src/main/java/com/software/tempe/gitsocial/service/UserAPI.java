package com.software.tempe.gitsocial.service;

import com.software.tempe.gitsocial.model.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface UserAPI {
    @GET
    Call<UserList> getUser(@Url String url);
}
