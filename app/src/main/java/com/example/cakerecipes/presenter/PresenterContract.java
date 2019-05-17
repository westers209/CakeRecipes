package com.example.cakerecipes.presenter;

import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.view.ViewContract;

import java.util.List;

import okhttp3.Cache;

public interface PresenterContract {

    void bind(ViewContract view);

    void unbind();

    List<CakeDetailsPojo> getCakes();

    void initNetworkConnection(Cache cache);

    void networkSuccessful(List<CakeDetailsPojo> dataSet);

    void networkFailure(String message);

}
