package com.moosa.rxdagger.base;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */

public interface Presenter {
    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
