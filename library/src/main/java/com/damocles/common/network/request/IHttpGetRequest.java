/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.network.request;

import java.util.Map;

/**
 * Created by zhanglong02 on 17/6/23.
 */

public interface IHttpGetRequest {

    String getUrl();

    void execute();

    void cancel();

}
