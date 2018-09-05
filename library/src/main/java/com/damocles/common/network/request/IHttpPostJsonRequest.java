/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.network.request;

/**
 * Created by zhanglong02 on 17/6/23.
 */

public interface IHttpPostJsonRequest {

    String getUrl();

    String getPostJson();

    void execute();

    void cancel();
}
