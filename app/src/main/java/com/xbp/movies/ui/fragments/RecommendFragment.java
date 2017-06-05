package com.xbp.movies.ui.fragments;

import android.view.LayoutInflater;

import com.xbp.movies.R;
import com.xbp.movies.base.BaseFragment;
import com.xbp.movies.ui.views.RecommendView;

import butterknife.BindView;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 15:01
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public class RecommendFragment extends BaseFragment {
    @BindView(R.id.fragment_recommendView)
    RecommendView recommendView;
    @Override
    public void lazyFetchData() {

    }

    @Override
    protected void initView(LayoutInflater inflater) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }
}
