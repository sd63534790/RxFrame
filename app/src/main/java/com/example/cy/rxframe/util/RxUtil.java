package com.example.cy.rxframe.util;

import com.example.cy.rxframe.model.bean.AndroidAPI;
import com.example.cy.rxframe.model.http.exception.ApiException;
import com.example.cy.rxframe.model.http.response.GankApiResult;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }

    /**
     * 统一返回结果处理
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<GankApiResult<T>, T> handleResult() {   //compose判断结果
        return new FlowableTransformer<GankApiResult<T>, T>() {
            @Override
            public Flowable<T> apply(Flowable<GankApiResult<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<GankApiResult<T>, Flowable<T>>() {
                    @Override
                    public Flowable<T> apply(GankApiResult<T> tGankHttpResponse) {
                        if(!tGankHttpResponse.isError()) {
                            return createData(tGankHttpResponse.getResults());
                        } else {
                            return Flowable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }
}
