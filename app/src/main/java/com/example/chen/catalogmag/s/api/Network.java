package com.example.chen.catalogmag.s.api;

import com.example.chen.catalogmag.s.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by chen on 04.04.16.
 */
public class Network {
    private static Network instance;
    private final Api result;
    private Network() {
        OkHttpClient httpClient = new OkHttpClient();
        Gson gson  = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                                .client(httpClient)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .baseUrl(Constants.BASE_URL)
                                .build();

        result = retrofit.create(Api.class);
    }

    public static synchronized Api getInterface(){
        if(instance == null){
            instance = new Network();
        }

        return instance.getResult();
    }

    public Api getResult(){
        return result;
    }
}
