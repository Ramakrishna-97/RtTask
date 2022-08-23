package com.example.retrofittask;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("6b4b3d19-8ebb-4c19-ac51-3c825f0653b9")
    Call<JsonResponse> getResponselist();

// https://run.mocky.io/v3/ 6b4b3d19-8ebb-4c19-ac51-3c825f0653b9
}
