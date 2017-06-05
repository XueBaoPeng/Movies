package com.xbp.movies.ui.activitys;

import android.os.Bundle;

import com.xbp.movies.R;
import com.xbp.movies.base.BaseActivity;
import com.xbp.movies.ui.views.MainView;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_view)
    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
