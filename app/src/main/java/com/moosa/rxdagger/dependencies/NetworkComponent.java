package com.moosa.rxdagger.dependencies;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */

@Singleton
@Component(modules = NetworkModule.class)
public interface NetworkComponent {

    Retrofit retrofit();

}
