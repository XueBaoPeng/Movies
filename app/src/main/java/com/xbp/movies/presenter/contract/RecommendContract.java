package com.xbp.movies.presenter.contract;

import com.xbp.movies.base.BasePresenter;
import com.xbp.movies.base.BaseView;
import com.xbp.movies.model.net.bean.VideoRes;

/**
 * Created by Administrator on 2017/6/5.
 */

public interface RecommendContract {

    interface View extends BaseView<Presenter> {
        void showContent(VideoRes videoRes);
        void showErrorContent(String error);
    }

    interface Presenter extends BasePresenter {
        void onloadData();
    }
}
