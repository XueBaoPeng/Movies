package com.xbp.movies.base;

/**
 * Created by Administrator on 2017/6/5.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);

    void showError();
}
