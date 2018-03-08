package com.example.cmd.weatherapi.FragmentContainers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.cmd.weatherapi.Adapters.SOAdapter;
import com.example.cmd.weatherapi.ApiUtils.ApiUtils;
import com.example.cmd.weatherapi.R;
import com.example.cmd.weatherapi.REST.RetrofitCLient;
import com.example.cmd.weatherapi.data.model.Item;
import com.example.cmd.weatherapi.data.model.SOAnwserResponse;
import com.example.cmd.weatherapi.data.model.remote.RetrofitApiCall;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView mRecycler;
    private RetrofitApiCall mClient;
    private SOAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mClient = ApiUtils.getClient();
        mRecycler = (RecyclerView) findViewById(R.id.recyclerViewFragment);
        mRecycler.hasFixedSize();
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SOAdapter(new ArrayList<Item>(0),this );
        mRecycler.setAdapter(mAdapter);

        loadsAnswers();







    }

    private void loadsAnswers() {
        mClient.getAnswer().enqueue(new Callback<SOAnwserResponse>() {
            @Override
            public void onResponse(Call<SOAnwserResponse> call, Response<SOAnwserResponse> response) {
                if (response.isSuccessful()) {
                    mAdapter.updateItems(response.body().getItems());
                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode  = response.code();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SOAnwserResponse> call, Throwable t) {
                t.getMessage();
            }
        });
    }
}
