package com.example.cakerecipes.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CakeApiInterface {

    //Base URL:
    //https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/

    @GET ("cake.json")
    Call<List<CakeDetailsPojo>> getCakeList();
    //List because it's a json array.
    //If you did Call<CakeDtailsPojo> you'd only be asking for one item.
    //List<List<X>> is bad practice
}
