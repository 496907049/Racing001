package com.shuwo.racing001.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dou361.dialogui.bean.BuildBean;
import com.shuwo.racing001.R;
import com.shuwo.racing001.Util.HorseRaceLampUtil;
import com.shuwo.racing001.Util.ImageSliderUtil;
import com.shuwo.racing001.Util.ToastUtils;
import com.shuwo.racing001.adapter.ScoreResultAdapter;
import com.shuwo.racing001.bean.News;
import com.shuwo.racing001.bean.ScoreResult;
import com.shuwo.racing001.present.IBasePresent;
import com.shuwo.racing001.present.impl.IBasePresentImpl;
import com.shuwo.racing001.present.impl.IScoreResultPresentImpl;
import com.shuwo.racing001.view.IBaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus01 on 2017/11/24.
 */

public class ScoreResultActivity extends BaseActivity implements IBaseView,BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    BaseQuickAdapter adapter;
    private List<ScoreResult> beanList = new ArrayList<>();

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView mRecyclerView;
    private IBasePresent basePresent;

    private int delayMillis = 1000;
    private int pageSize = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showBuildBean();
        basePresent = new IScoreResultPresentImpl(this, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));

//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));    //  2条数据
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));    //一条数据
        adapter = new ScoreResultAdapter(R.layout.activity_score_result_adapter, beanList);
        adapter.setOnLoadMoreListener(this, mRecyclerView);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
        mRecyclerView.setAdapter(adapter);
        basePresent.getInfoList("f1zsresultAccess",pageSize,"yes");

    }

    @Override
    public void onRefresh() {
        pageSize =10;
        basePresent.getInfoList("f1zsresultAccess",pageSize,"yes");

    }

    @Override
    public void onLoadMoreRequested() {
        pageSize += 10;
        basePresent.getLoadMoreInfoList("f1zsresultAccess",pageSize,"yes");
    }

    @Override
    public void showInfoList(List infoList) {
        beanList = infoList;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setNewData(beanList);
                adapter.setEnableLoadMore(true);
                mSwipeRefreshLayout.setRefreshing(false);
                dismissBuildBean();
            }
        }, delayMillis);
    }

    @Override
    public void showLoadMoreInfoList(List infoList) {
        mSwipeRefreshLayout.setEnabled(false);
        if(infoList.size()>beanList.size()){
            List<ScoreResult> infoList2 = new ArrayList<>();
            for(int i = infoList.size()-(infoList.size()-beanList.size());i<infoList.size();i++){
                infoList2.add((ScoreResult) infoList.get(i));
            }
            adapter.addData(infoList2);   //添加数据
            adapter.loadMoreComplete();
        }else {
            adapter.loadMoreEnd(false);//true is gone,false is visible    //没有更多数据
            ToastUtils.show(this,"已加载全部！");
        }
        mSwipeRefreshLayout.setEnabled(true);
    }

}
