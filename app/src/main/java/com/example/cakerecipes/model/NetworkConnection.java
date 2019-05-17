package com.example.cakerecipes.model;

import com.example.cakerecipes.presenter.Presenter;

import java.util.List;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnection {


    //Lines 9-16 is how you make a singleton. A very simple one though.
    private NetworkConnection() {
    }

    private static NetworkConnection instance;
    private static Presenter presenter;

    //.enqueue actually generates this part automagically inside intiRetrofit.
    Callback<List<CakeDetailsPojo>> callback = new Callback<List<CakeDetailsPojo>>() {
        @Override
        public void onResponse(Call<List<CakeDetailsPojo>> call, Response<List<CakeDetailsPojo>> response) {
            if (response.isSuccessful() && response != null) {
                presenter.networkSuccessful(response.body());

            }
        }

        @Override
        public void onFailure(Call<List<CakeDetailsPojo>> call, Throwable t) {
            presenter.networkFailure(t.getMessage());
        }
    };

    public static NetworkConnection getInstance() {
        if (instance == null) {
            instance = new NetworkConnection();
        }
        return instance;
    }

    public void setPresenter(Presenter presenter) {
        instance.presenter = presenter;
    }

    public void initRetrofit(Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();
        new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/" +
                        "8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CakeApiInterface.class)
                .getCakeList()
                .enqueue(callback);
    }


}
