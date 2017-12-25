package com.example.cy.rxframe.presenter.gank;

import com.example.cy.rxframe.base.RxPresenter;
import com.example.cy.rxframe.model.DataManager;
import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.model.bean.WelfareAPI;
import com.example.cy.rxframe.model.http.response.GankApiResult;
import com.example.cy.rxframe.util.RxUtil;
import com.example.cy.rxframe.widget.CommonSubscriber;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;

/**
 * Created by cheny on 2017/11/8.
 */

public class AndroidPresenter extends RxPresenter<AndroidContract.View> implements AndroidContract.Presenter {

    DataManager mDataManager;

    @Inject
    public AndroidPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void loadAndroidDatas(int pageSize, int pageIndex) {
        mView.showLoading();
        addSubscribe(Flowable.zip(mDataManager.getAndroidData(pageSize, pageIndex), mDataManager.getWalfareData(pageSize, pageIndex),
                new BiFunction<GankApiResult<List<AndroidAPI>>, GankApiResult<List<WelfareAPI>>, GankApiResult<List<AndroidAPI>>>() {
                    @Override
                    public GankApiResult<List<AndroidAPI>> apply(GankApiResult<List<AndroidAPI>> listGankApiResult, GankApiResult<List<WelfareAPI>> listGankApiResult2) throws Exception {
                        return mergeData(listGankApiResult, listGankApiResult2);
                    }
                })
                .compose(RxUtil.<GankApiResult<List<AndroidAPI>>>rxSchedulerHelper())
                .compose(RxUtil.<List<AndroidAPI>>handleResult())
                .subscribeWith(new CommonSubscriber<List<AndroidAPI>>(mView) {
                    @Override
                    public void onNext(List<AndroidAPI> datas) {
                        mView.showAndroidList(datas);
                    }
                }));
    }

    @Override
    public void refreshAndroidDatas(int pageSize, int pageIndex) {

    }

    /**
     * 合并数据
     */
    private GankApiResult<List<AndroidAPI>> mergeData(GankApiResult<List<AndroidAPI>> androidResult, GankApiResult<List<WelfareAPI>> welfareResult) {
        for (int i = 0; i < androidResult.getResults().size(); i++) {
            androidResult.getResults().get(i).setImageUrl(welfareResult.getResults().get(i).getUrl());
        }
        return androidResult;
    }
}
