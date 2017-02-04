package com.moosa.rxdagger.base;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Moosa on 03/02/2017.
 * moosa.bh@gmail.com
 */

public abstract class BasePresenter implements Presenter {
    private CompositeDisposable compositeSubscription;

    @Override
    public void onCreate() {
        configureSubscription();
    }

    @Override
    public void onResume() {

    }

    private CompositeDisposable configureSubscription() {
        if (compositeSubscription == null || compositeSubscription.isDisposed()) {
            compositeSubscription = new CompositeDisposable();
        }
        return compositeSubscription;
    }


    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    protected void unSubscribeAll() {
        if (compositeSubscription != null) {
            compositeSubscription.dispose();
            compositeSubscription.clear();
            //compositeSubscription = null;
        }
    }

    protected <T> void subscribe(Observable<T> observable, Consumer<T> observer) {
        Disposable subscriber = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        compositeSubscription.add(subscriber);
    }

}
