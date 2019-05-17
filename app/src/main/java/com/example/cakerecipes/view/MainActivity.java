package com.example.cakerecipes.view;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.cakerecipes.R;
import com.example.cakerecipes.model.CakeDetailsPojo;
import com.example.cakerecipes.presenter.Presenter;

import java.util.List;

import okhttp3.Cache;

public class MainActivity extends AppCompatActivity implements ViewContract {

    private Presenter presenter;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindPresenter();

        adapter = new CustomAdapter();
        adapter.setHasStableIds(true);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true); //Helps rendering by saying the data set's size will never change.
        recyclerView.setAdapter(adapter);

        populateCakeList();
    }

    @Override
    public void populateCakeList() {
        if (hasNetwork()) {
            long cacheSize = (5 * 1024 * 1024);
            Cache myCache = new Cache(getCacheDir(), cacheSize);
            presenter.initNetworkConnection(myCache);
        } else {
            onError("No network found");
        }
    }

    boolean hasNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void bindPresenter() {
        presenter = new Presenter();
        presenter.bind(this);
    }

    @Override
    public void getCakeList(List<CakeDetailsPojo> dataSet) {
        adapter.setDataSet(dataSet);
    }
}
