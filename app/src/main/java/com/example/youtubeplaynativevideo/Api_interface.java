package com.example.youtubeplaynativevideo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_interface {
    //    String BASE_URL ="https://www.googleapis.com/youtube/v3/search?key=&channelId=UC5SW-g2P73lZ-6JjyeguSVQ&part=snippet,id&maxResults=20";
    String Apikey = "AIzaSyAgGowXh6h-4uuJkEkWD5UPV_8EOWNP2KE";
    @GET("search")

    Call <serverResponse> getData(
            @Query("key") String api_key,
            @Query("channelId") String channelId,
            @Query("order") String date,
            @Query("part") String part,
            @Query("maxResults") int maxResults);

    // verify that is a get request using @get annotation  and put the last section of url









}



