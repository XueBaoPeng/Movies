package com.xbp.movies.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 13:11
 * 类作用：所有view的基类
 * 邮箱：13519297683@163.com
 * .......................................
 */

public abstract class RootView<T extends BasePresenter> extends LinearLayout{
    protected boolean mActive;//是否被销毁
    protected Context mContext;
    protected Unbinder unbinder;
    protected T mPresenter;

    public RootView(Context context) {
        super(context);
        init();
    }

    public RootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected abstract void getLayout();

    protected abstract void initView();

    protected abstract void initEvent();

    protected void init() {
        mContext = getContext();
        getLayout();
        unbinder = ButterKnife.bind(this);
        mActive = true;
        initView();
        initEvent();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mPresenter != null)
//            mPresenter.attachView(this);
        mActive = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null)
            mPresenter.detachView();
        mActive = false;
        unbinder.unbind();
        mContext = null;
    }
}
