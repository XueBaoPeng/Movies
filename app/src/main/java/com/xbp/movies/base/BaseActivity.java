package com.xbp.movies.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xbp.movies.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 13:20
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected Unbinder unbinder;
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init() {
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        App.getInstance().registerActivity(this);
    }

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        App.getInstance().unregisterActivity(this);
    }
}
