package com.xbp.movies.model.net.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xbp on 2017/6/5.
 */

public class OkHttpClient {
    private okhttp3.OkHttpClient okHttpClient;
    private static OkHttpClient instance;
    private Handler mainHandler;
    private Context context;


    private OkHttpClient(Context context) {
        this.context = context.getApplicationContext();
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        okHttpClient = builder.build();
        mainHandler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpClient getInstance(Context context) {
        if (instance == null)
            synchronized (OkHttpClient.class) {
                if (instance == null) {
                    instance = new OkHttpClient(context);
                }
            }
        return instance;
    }

    public <T> void sendGet(final RequestParams<T> requestParams) {
        Request request = new Request.Builder().url(requestParams.url).method("GET", null).build();
        Call call = okHttpClient.newCall(request);
        if (requestParams.listener.onIntercept()) {
            requestParams.listener.onIntercept();
        }
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (requestParams.listener != null) {
                            requestParams.listener.onFailure(-1, e.getMessage());
                        }
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {//在子线程中运行用handler发送到主线程
                if (response.isSuccessful()) {//请求结果成功
                    String result = null;
                    try {
                        result = response.body().string();
                        final T t = JSONUtil.getFromJSON(result, requestParams.aClass);
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (requestParams.listener != null) {
                                    requestParams.listener.onSuccess(t);
                                }
                            }
                        });
                    } catch (IOException e) {
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (requestParams.listener != null) {
                                    requestParams.listener.onFailure(response.code(), response.message());
                                }
                            }
                        });
                    }
                } else {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (requestParams.listener != null) {
                                requestParams.listener.onFailure(response.code(), response.message());
                            }
                        }
                    });
                }
            }
        });
    }
}
