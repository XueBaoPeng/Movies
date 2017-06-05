package com.xbp.movies.ui.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.xbp.movies.R;
import com.xbp.movies.base.RootView;

import butterknife.BindView;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 15:16
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public class ClassificationView extends RootView {

    @BindView(R.id.tv_content)
    TextView tv_content;
    public ClassificationView(Context context) {
        super(context);
    }

    public ClassificationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_classification_view, this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }
}
