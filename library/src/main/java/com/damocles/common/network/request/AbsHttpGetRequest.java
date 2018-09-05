/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.network.request;

import java.util.List;

import com.damocles.common.network.HttpManager;
import com.damocles.common.network.callback.HttpCallback;

import android.util.Log;

/**
 * Created by zhanglong02 on 17/6/23.
 */

public abstract class AbsHttpGetRequest implements IHttpGetRequest, HttpCallback {

    protected static final String TAG = "network";

    private String mRequesUrl;

    @Override
    public void execute() {
        mRequesUrl = getUrl();
        HttpManager.get(mRequesUrl, this);
    }

    @Override
    public void cancel() {
        HttpManager.cancelRequest(mRequesUrl);
    }

    @Override
    public void onCancel(String url) {
        Log.e(TAG, getClass().getSimpleName() + " canceled!");
    }

    @Override
    public void onCookies(String url, List<String> cookies) {

    }

}
