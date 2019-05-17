package com.example.cakerecipes.presenter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.model.NetworkConnection;
import com.example.cakerecipes.view.MainActivity;
import com.example.cakerecipes.view.ViewContract;

import java.util.List;

import okhttp3.Cache;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class Presenter implements PresenterContract {

    private ViewContract view;
    private NetworkConnection network;
    private List<CakeDetailsPojo> dataSet;

    @Override
    public void bind(ViewContract view) {
        this.view = view;
        network = NetworkConnection.getInstance();
    }

    @Override
    public void unbind() {
        view = null;
        dataSet = null;
        network = null;
    }

    //Returns list of cakes to the view
    @Override
    public List<CakeDetailsPojo> getCakes() {
        return null;
    }

    @Override
    public void initNetworkConnection(Cache cache) {
        network.setPresenter(this);
        network.initRetrofit(cache);
    }

    @Override
    public void networkSuccessful(List<CakeDetailsPojo> dataSet) {
        view.getCakeList(dataSet);
    }

    @Override
    public void networkFailure(String message) {
        view.onError(message);
    }



}
