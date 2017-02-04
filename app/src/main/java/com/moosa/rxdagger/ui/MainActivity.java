package com.moosa.rxdagger.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.moosa.rxdagger.AppController;
import com.moosa.rxdagger.R;
import com.moosa.rxdagger.base.FlowerPresenter;
import com.moosa.rxdagger.model.FlowerResponse;
import com.moosa.rxdagger.service.FlowerService;
import com.moosa.rxdagger.service.FlowerViewInterface;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity implements FlowerViewInterface, FlowerAdapter.FlowerClickListener {

    @BindView(R.id.flowersListView) RecyclerView mRecyclerView;

    @Inject
    FlowerService flowerService;

    FlowerPresenter flowerPresenter;
    private FlowerAdapter mAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mRecyclerView = (RecyclerView) findViewById(R.id.flowersListView);
         ButterKnife.bind(MainActivity.this);
        ((AppController) getApplication())
                .getApiComponent()
                .injectOrBind(MainActivity.this);
        configViews();

        flowerPresenter = new FlowerPresenter(this);
        flowerPresenter.onCreate();

    }
    private void configViews() {
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FlowerAdapter(this, getLayoutInflater());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        flowerPresenter.fetchFlowersList();

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Downloading List");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        progressDialog.dismiss();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onFlowerResponse(List<FlowerResponse> flowerResponses) {
        progressDialog.dismiss();
        mAdapter.addFlowers(flowerResponses);
    }

    @Override
    public Observable<List<FlowerResponse>> getFlowersObservable() {
        return flowerService.flowersList();
    }

    @Override
    public void onClick(int position, String name) {
        Toast.makeText(this,"Name: "+name +" - Pos:"+position,Toast.LENGTH_SHORT).show();
    }
}
