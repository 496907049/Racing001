package com.shuwo.racing001.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shuwo.racing001.R;
import com.shuwo.racing001.Util.HorseRaceLampUtil;
import com.shuwo.racing001.Util.ImageSliderUtil;
import com.shuwo.racing001.Util.ToastUtils;
import com.shuwo.racing001.activity.BodyActivity;
import com.shuwo.racing001.adapter.TwoTextLeftAndOneImgRightAdapter;
import com.shuwo.racing001.bean.News;
import com.shuwo.racing001.bean.ScoreBoard;
import com.shuwo.racing001.present.IBasePresent;
import com.shuwo.racing001.present.IScoreBoardPresent;
import com.shuwo.racing001.present.impl.IBasePresentImpl;
import com.shuwo.racing001.present.impl.IScoreBoardPresentImpl;
import com.shuwo.racing001.view.IBaseView;
import com.shuwo.racing001.view.IScoreBoardView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus01 on 2017/10/17.
 */

public class HomePageFragment extends BaseFragment implements IBaseView,IScoreBoardView,SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener{

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private List<News> beanList = new ArrayList<>();
    private int delayMillis = 1000;
    private int pageSize = 10;

    private IBasePresent basePresent;
    private IScoreBoardPresent scoreBoardPresent;

    private List<String> stringsList = new ArrayList<>();

    View fragmentView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_base_no_title, null);
        showBuildBean();

        mRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.rv_list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) fragmentView.findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TwoTextLeftAndOneImgRightAdapter(R.layout.two_text_left_one_img_right, beanList);
        adapter.setOnLoadMoreListener(this, mRecyclerView);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        //添加headview
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), BodyActivity.class);
                intent.putExtra("body", beanList.get(position).getBody());
                intent.putExtra("picture", beanList.get(position).getPicture());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);

        //获取接口<F1车队积分榜>数据
        scoreBoardPresent = new IScoreBoardPresentImpl(this,getContext());
        scoreBoardPresent.getScoreBoardList("f1cdjifenAccess");

        //获取接口<F1赛车新闻>数据
        basePresent = new IBasePresentImpl(this,getContext());
        return fragmentView;
    }

    @Override
    public void onRefresh() {
        pageSize =10;
        adapter.removeAllHeaderView();
        scoreBoardPresent.getScoreBoardList("f1cdjifenAccess");

    }

    @Override
    public void onLoadMoreRequested() {
        pageSize += 10;
        basePresent.getLoadMoreInfoList("f1sallNewsAccess",pageSize,"yes");
    }


    @Override
    public void showInfoList(List newsList) {
        beanList = newsList;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addHeaderView(ImageSliderUtil.initImageSlider(getContext()));
                adapter.addHeaderView(HorseRaceLampUtil.getHorseRaceLamp(getContext(),stringsList));
                adapter.setNewData(beanList);
                adapter.setEnableLoadMore(true);
                mSwipeRefreshLayout.setRefreshing(false);
                dismissBuildBean();
            }
        }, delayMillis);
    }

    @Override
    public void showLoadMoreInfoList(List newsList) {
        mSwipeRefreshLayout.setEnabled(false);
        if(newsList.size()>beanList.size()){
            List<News> infoList2 = new ArrayList<>();
            for(int i = newsList.size()-(newsList.size()-beanList.size());i<newsList.size();i++){
                infoList2.add((News) newsList.get(i));
            }
            adapter.addData(infoList2);   //添加数据
            adapter.loadMoreComplete();
        }else {
            adapter.loadMoreEnd(false);//true is gone,false is visible    //没有更多数据
            ToastUtils.show(getContext(),"已加载全部！");
        }
        mSwipeRefreshLayout.setEnabled(true);
    }

    @Override
    public void showScoreboardList(List<ScoreBoard> scoreList) {
        for(ScoreBoard bean:scoreList){
               stringsList.add( bean.getChedui()+"   "+bean.getJifen());
        }
        basePresent.getInfoList("f1sallNewsAccess",pageSize,"yes");
    }

    @Override
    public void showLoadMoreScoreboardList(List<ScoreBoard> scoreList) {

    }
}


