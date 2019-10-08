package com.lipsel.videoupload.network;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface ServiceInterface {
    //http://softcodeinfotech.com/tiktest/get_videolist.php
    @Multipart
    @POST("tiktest/get_videolist.php")
    Call<VideolistResponse> getVideolistCall(
            @Part("securecode") RequestBody securecode
    );

   /* @Multipart
    @POST("images/upload_image.php")
    Call<ServerResponse> upload(
            @Header("Authorization") String authorization,
            @PartMap Map<String, RequestBody> map
    );*/
}
