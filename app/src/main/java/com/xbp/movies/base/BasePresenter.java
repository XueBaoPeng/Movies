package com.xbp.movies.base;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 13:16
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public interface BasePresenter<T> {
   void attarthView(T view);
    void detachView();
}
