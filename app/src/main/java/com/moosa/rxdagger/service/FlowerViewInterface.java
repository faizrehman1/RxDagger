package com.moosa.rxdagger.service;

import com.moosa.rxdagger.model.FlowerResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Moosa on 04/02/2017.
 * moosa.bh@gmail.com
 */

public interface FlowerViewInterface {
    void onFlowerResponse(List<FlowerResponse> flowerResponses);

    Observable<List<FlowerResponse>> getFlowersObservable();
}
