package com.xbp.movies.model.net.net;

import android.content.Context;

/**
 * Created by  xbp on 2017/6/5.
 * 网络请求的最上层入口，所有请求都走该层，方便后续替换
 */

public class HttpManager {

    private static HttpManager instance;
    private Context context;

    /**
     * @param context 需要传入applicationContext,否则容易造成内存泄漏
     * @return
     */
    public static void init(Context context) {
        if (instance == null)
            synchronized (HttpManager.class) {
                if (instance == null)
                    instance = new HttpManager();
            }
        instance.context = context.getApplicationContext();
    }


    public static synchronized <T> void get(String url, Class<T> clazz, DataCallback<T> dataCallback) {
        RequestParams<T> params = new RequestParams<T>();
        params.url = url;
        params.listener = dataCallback;
        params.aClass=clazz;
        OkHttpClient.getInstance(instance.context).sendGet(params);
    }

}
