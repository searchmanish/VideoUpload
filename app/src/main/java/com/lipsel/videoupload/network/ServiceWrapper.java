package com.lipsel.videoupload.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lipsel.videoupload.BuildConfig;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceWrapper {
    //http://softcodeinfotech.com/tiktest/get_videolist.php
    public static final long API_CONNECTION_TIMEOUT = 1601;
    public static final long API_READ_TIMEOUT = 1201;
    public static final String BASE_URL = "http://softcodeinfotech.com/";

    private ServiceInterface mServiceInterface;

    public ServiceWrapper(Interceptor mInterceptorheader) {
        mServiceInterface = getRetrofit(mInterceptorheader).create(ServiceInterface.class);
    }

    public Retrofit getRetrofit(Interceptor mInterceptorheader) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient mOkHttpClient = null;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(API_CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(API_READ_TIMEOUT, TimeUnit.SECONDS);


        if (BuildConfig.DEBUG) {
            // HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }


        mOkHttpClient = builder.build();
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(mOkHttpClient)
                .build();
        return retrofit;
    }


    ///  videolist details details
    public Call<VideolistResponse> getVideolist(String securcode) {
        return mServiceInterface.getVideolistCall(convertPlainString(securcode));
    }
    /*public Call<ServerResponse> upload(String auth, Map map)
    {
        return mServiceInterface.upload(String auth, Map map);
    }*/

    // convert aa param into plain text
    public RequestBody convertPlainString(String data) {
        RequestBody plainString = RequestBody.create(MediaType.parse("text/plain"), data);
        return plainString;
    }
}
