package com.example.cakerecipes.view;

import com.example.cakerecipes.model.CakeDetailsPojo;

import java.util.List;

public interface ViewContract {
    void populateCakeList();
    void onError(String message);
    void bindPresenter();
    void getCakeList(List<CakeDetailsPojo> dataSet);

}
