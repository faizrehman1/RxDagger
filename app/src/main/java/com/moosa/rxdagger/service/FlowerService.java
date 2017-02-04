package com.moosa.rxdagger.service;

import com.moosa.rxdagger.model.FlowerResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Moosa on 02/02/2017.
 * moosa.bh@gmail.com
 */

public interface FlowerService {
    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> flowersList();
}
