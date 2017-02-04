package com.moosa.rxdagger;

import android.app.Application;

import com.moosa.rxdagger.dependencies.ApiComponent;
import com.moosa.rxdagger.dependencies.DaggerApiComponent;
import com.moosa.rxdagger.dependencies.DaggerNetworkComponent;
import com.moosa.rxdagger.dependencies.NetworkComponent;
import com.moosa.rxdagger.dependencies.NetworkModule;
import com.moosa.rxdagger.util.Constant;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */

public class AppController extends Application {
    private ApiComponent apiComponent;

    public ApiComponent getApiComponent() {
        return apiComponent;
    }

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        apiComponent = DaggerApiComponent
                .builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {

        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }
}
