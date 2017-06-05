package com.xbp.movies.presenter;

import com.xbp.movies.app.Contants;
import com.xbp.movies.model.net.bean.VideoResult;
import com.xbp.movies.model.net.net.DataCallback;
import com.xbp.movies.model.net.net.HttpManager;
import com.xbp.movies.presenter.contract.RecommendContract;

/**
 * Created by Administrator on 2017/6/5.
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    RecommendContract.View mView;

    public RecommendPresenter(RecommendContract.View mView) {
        this.mView = mView;
        this.mView.setPresenter(this);
    }

    @Override
    public void onloadData() {
        HttpManager.get(Contants.homePageUrl, VideoResult.class, new DataCallback<VideoResult>() {
            @Override
            public boolean onIntercept() {
                return false;
            }

            @Override
            public void onSuccess(VideoResult videoResult) {
                mView.showContent(videoResult.ret);
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                mView.showErrorContent(msg);
            }
        });
    }

    @Override
    public void attarthView(Object view) {

    }

    @Override
    public void detachView() {

    }
}
