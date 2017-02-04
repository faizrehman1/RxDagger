package com.moosa.rxdagger.base;

import com.moosa.rxdagger.model.FlowerResponse;
import com.moosa.rxdagger.service.FlowerViewInterface;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */

public class FlowerPresenter extends BasePresenter implements Consumer<List<FlowerResponse>> {
    private FlowerViewInterface flowerViewInterface;

    public FlowerPresenter(FlowerViewInterface flowerViewInterface) {
        this.flowerViewInterface = flowerViewInterface;
    }

    @Override
    public void accept(List<FlowerResponse> flowerResponses) throws Exception {
        flowerViewInterface.onFlowerResponse(flowerResponses);
    }

    public void fetchFlowersList() {
        unSubscribeAll();
        subscribe(flowerViewInterface.getFlowersObservable() , this);
    }
}

