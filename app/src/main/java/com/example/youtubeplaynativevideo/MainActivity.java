package com.example.youtubeplaynativevideo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends YouTubeBaseActivity implements View.OnClickListener {


    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    //ImageView imageView1;
    ArrayList<String> videosIDs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);


    }

    public void fetchData(String channelId, int maxRes, String order, String part, String api_key) {
        String BASE_URL = "https://www.googleapis.com/youtube/v3/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_interface api = retrofit.create(Api_interface.class);


        api.getData(api_key, channelId, order, part, maxRes)
                .enqueue(new Callback<serverResponse>() {
                    @Override
                    public void onResponse(Call<serverResponse> call, Response<serverResponse> response) {
                        Toast.makeText(MainActivity.this, "successssssssssssssssssss", Toast.LENGTH_SHORT).show();
                        serverResponse serverResponse = response.body();


                        ArrayList<Items> items = serverResponse.getItems();
                        for (int i = 0; i < items.size(); i++) {
                            videosIDs.add(items.get(i).getId().getVideoId());

                        }
                        Bundle args = new Bundle();
                        args.putStringArrayList("videos", videosIDs);
                        Detailed_fragment detailed_fragment = new Detailed_fragment();
                        detailed_fragment.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.frame_home, detailed_fragment, "").commit();

                    }

                    @Override
                    public void onFailure(Call<serverResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        Log.i("onFailure: ", t.getMessage());
                        ;
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView1:
                fetchData("UC5r25vHHPqBUhNa358-2caQ", 20, "date", "snippet,id", Api_interface.Apikey);

                break;
            case R.id.imageView2:
                fetchData("UCs8ynQgjoKZblUXosXoeOEQ", 20, "date", "snippet,id", Api_interface.Apikey);

                break;
            case R.id.imageView3:
                fetchData("UCZghOmDezc6OCMzdPaL-j2Q", 20, "date", "snippet,id", Api_interface.Apikey);

                break;
            case R.id.imageView4:
                fetchData("UCvyN-kMH-IrXzWNeZaQ_XaQ", 20, "date", "snippet,id", Api_interface.Apikey);

                break;
            case R.id.imageView5:
                fetchData("UC5ctH9--_UlE-HQ1GyjACdg", 20, "date", "snippet,id", Api_interface.Apikey);


            default:
                return;


        }
    }
}
