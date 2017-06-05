package com.xbp.movies.model.net.net;

import java.util.Map;

/**
 * Created by xbp on 2017/6/5.
 * 请求参数
 */

public class RequestParams<T> {
    /**
     * 请求参数
     */
    public String url;
    /**
     * 请求参数 post专用
     */
    public Map<String, Object> params;

    /**
     * 请求数据回调
     */
    public DataCallback<T> listener;
    /**
     * 解析的类实体
     */
    public Class<T> aClass;

}
