package com.chace.testrx.module.basefeature.presenter;

import android.util.Log;

import com.chace.testrx.model.ZBImageInfo;
import com.chace.testrx.module.basefeature.view.ElementryViewInterface;
import com.chace.testrx.network.Network;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chacewang on 16/9/23.
 */
public class ElementryPresenter {
    private ElementryViewInterface mViewInterface;
    private Subscription mSubscription;
    private Observer<List<ZBImageInfo>> mObserver;
    private static final String TAG = "ElementryPresenter";

    public ElementryPresenter(ElementryViewInterface viewInterface) {
        mViewInterface = viewInterface;
        mObserver = new Observer<List<ZBImageInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "updateImageView onError: " + e);
                mViewInterface.updateEnd();
            }

            @Override
            public void onNext(List<ZBImageInfo> zbImageInfos) {
                mViewInterface.updateImageView(zbImageInfos);
                mViewInterface.updateEnd();
            }
        };
    }

    public void updateImageInfos(String query) {
        mViewInterface.updateStart();
        mSubscription = Network.getZBApi()
                .search(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }

    public void unSubscribe() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
            mSubscription = null;
        }
    }
}
