package com.moosa.rxdagger.dependencies;

import com.moosa.rxdagger.ui.MainActivity;

import dagger.Component;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */
@CustomScope
@Component(modules = ApiModule.class , dependencies = NetworkComponent.class)
public interface ApiComponent {


    void injectOrBind(MainActivity mainActivity);
}
