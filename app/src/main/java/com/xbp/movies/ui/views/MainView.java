package com.xbp.movies.ui.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.MenuItem;

import com.xbp.movies.R;
import com.xbp.movies.base.RootView;
import com.xbp.movies.ui.activitys.MainActivity;
import com.xbp.movies.ui.adapter.ContentPagerAdapter;
import com.xbp.movies.ui.fragments.ClassificationFragment;
import com.xbp.movies.ui.fragments.DiscoverFragment;
import com.xbp.movies.ui.fragments.MineFragment;
import com.xbp.movies.ui.fragments.RecommendFragment;
import com.xbp.movies.widget.UnScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 13:31
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public class MainView extends RootView implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.vp_content)
    UnScrollViewPager vpContent;
    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    ContentPagerAdapter mPagerAdapter;
    MainActivity mActivity;

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
    }

    @Override
    protected void initView() {
        mActivity=(MainActivity)mContext;
        List<Fragment> fragments = initFragments();
        vpContent.setScrollable(false);
        mPagerAdapter = new ContentPagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        vpContent.setAdapter(mPagerAdapter);
        vpContent.setOffscreenPageLimit(fragments.size());
    }

    @Override
    protected void initEvent() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
    private List<Fragment> initFragments() {
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment1 = new RecommendFragment();
        Fragment fragment2 = new ClassificationFragment();
        Fragment fragment3 = new DiscoverFragment();
        Fragment mineFragment = new MineFragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(mineFragment);
        return fragments;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_selected:
                vpContent.setCurrentItem(0, false);
                return true;
            case R.id.navigation_special:
                vpContent.setCurrentItem(1, false);
                return true;
            case R.id.navigation_find:
                vpContent.setCurrentItem(2, false);
                return true;
            case R.id.navigation_mine:
                vpContent.setCurrentItem(3, false);
                return true;
        }
        return false;
    }
}
