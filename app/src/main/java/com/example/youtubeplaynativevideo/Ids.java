package com.example.youtubeplaynativevideo;

import com.google.gson.annotations.SerializedName;

class Ids {


    @SerializedName("videoId")
    String videoId;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
