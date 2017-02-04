package com.moosa.rxdagger.dependencies;

import com.moosa.rxdagger.service.FlowerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */

@Module
public class ApiModule {

    @Provides
    @CustomScope
    FlowerService provideFlowerService(Retrofit retrofit){
        return retrofit.create(FlowerService.class);
    }

}
