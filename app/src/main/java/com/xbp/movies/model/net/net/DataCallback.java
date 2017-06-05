package com.xbp.movies.model.net.net;

/**
 * Created by xbp on 2017/6/5.
 */

public interface DataCallback<T> {

    /**
     * 是否拦截此次请求
     *
     * @return true 拦截不会再请求数据
     */
    boolean onIntercept();

    /**
     * 请求到正确结果会调用
     *
     * @param t
     */
    void onSuccess(T t);

    /**
     * 状态码
     *
     * @param errorCode
     * @param msg
     */
    void onFailure(int errorCode, String msg);

}
