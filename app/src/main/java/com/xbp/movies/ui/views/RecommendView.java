package com.xbp.movies.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.xbp.movies.R;
import com.xbp.movies.base.RootView;
import com.xbp.movies.model.net.bean.VideoRes;
import com.xbp.movies.model.net.bean.VideoType;
import com.xbp.movies.presenter.contract.RecommendContract;

import butterknife.BindView;

/**
 * .......................................
 * 作者：薛宝鹏 on
 * 时间：2017/6/4 0004 15:19
 * 类作用：
 * 邮箱：13519297683@163.com
 * .......................................
 */

public class RecommendView extends RootView implements RecommendContract.View {
    @BindView(R.id.tv_content)
    TextView tv_content;

    public RecommendView(Context context) {
        super(context);
    }

    public RecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_recommend_view, this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void setPresenter(RecommendContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showContent(VideoRes videoRes) {
        if (videoRes != null && videoRes.list != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (VideoType videoType : videoRes.list) {
                stringBuilder.append(videoType.title + "/n");
            }
            tv_content.setText(stringBuilder);
        }
    }

    @Override
    public void showErrorContent(String error) {
        tv_content.setText(error);
    }
}
