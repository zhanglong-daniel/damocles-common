/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.network.request;

import java.util.Map;

/**
 * Created by zhanglong02 on 17/6/23.
 */

public interface IHttpRequest {

    String getUrl();

    Map<String, String> getParams();

    void execute();

}
