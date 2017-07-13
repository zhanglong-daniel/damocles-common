/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.network.callback;

import java.util.List;

/**
 * Created by zhanglong02 on 16/12/2.
 */
public interface HttpCallback {

    void onSuccess(String url, int statusCode, String response);

    void onCookies(String url, List<String> cookies);

    void onError(String url, String errMsg);
}
