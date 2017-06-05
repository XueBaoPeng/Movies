package com.xbp.movies.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 14:30
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public class ContentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public ContentPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
