/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.network.request;

import com.damocles.common.network.HttpManager;
import com.damocles.common.network.callback.HttpCallback;

/**
 * Created by zhanglong02 on 17/6/23.
 */

public abstract class AbsHttpRequest implements IHttpRequest, HttpCallback {

    @Override
    public void execute() {
        HttpManager.post(getUrl(), getParams(), this);
    }

}
