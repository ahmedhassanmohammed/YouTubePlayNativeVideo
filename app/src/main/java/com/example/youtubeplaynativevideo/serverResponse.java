package com.example.youtubeplaynativevideo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class serverResponse {




    @SerializedName("items")
    private ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}


