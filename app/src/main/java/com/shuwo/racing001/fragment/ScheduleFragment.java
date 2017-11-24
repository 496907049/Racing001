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
import com.shuwo.racing001.adapter.ScheduleAdapter;
import com.shuwo.racing001.adapter.TwoTextLeftAndOneImgRightAdapter;
import com.shuwo.racing001.bean.News;
import com.shuwo.racing001.bean.Schedule;
import com.shuwo.racing001.present.IBasePresent;
import com.shuwo.racing001.present.IScoreBoardPresent;
import com.shuwo.racing001.present.impl.ISchedulePresentImpl;
import com.shuwo.racing001.present.impl.IScoreBoardPresentImpl;
import com.shuwo.racing001.view.IBaseView;
import com.shuwo.racing001.view.IScoreBoardView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus01 on 2017/11/24.
 */

public class ScheduleFragment extends BaseFragment implements IBaseView,SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener{

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private List<Schedule> beanList = new ArrayList<>();
    private int delayMillis = 1000;
    private int pageSize = 10;

    private IBasePresent basePresent;

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
        adapter = new ScheduleAdapter(R.layout.fragment_schedule_adapter, beanList);
        adapter.setOnLoadMoreListener(this, mRecyclerView);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        //添加headview
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(getActivity(), BodyActivity.class);
//                intent.putExtra("body", beanList.get(position).getBody());
//                intent.putExtra("picture", beanList.get(position).getPicture());
//                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);

        //获取接口<F1车队积分榜>数据
        basePresent = new ISchedulePresentImpl(this,getContext());
        basePresent.getInfoList("f1raceAccess",pageSize,"yes");

        return fragmentView;
    }

    @Override
    public void onRefresh() {
        pageSize =10;
        basePresent.getInfoList("f1raceAccess",pageSize,"yes");
    }

    @Override
    public void onLoadMoreRequested() {
        pageSize += 10;
        basePresent.getLoadMoreInfoList("f1raceAccess",pageSize,"yes");
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
            List<News> infoList2 = new ArrayList<>();
            for(int i = infoList.size()-(infoList.size()-beanList.size());i<infoList.size();i++){
                infoList2.add((News) infoList.get(i));
            }
            adapter.addData(infoList2);   //添加数据
            adapter.loadMoreComplete();
        }else {
            adapter.loadMoreEnd(false);//true is gone,false is visible    //没有更多数据
            ToastUtils.show(getContext(),"已加载全部！");
        }
        mSwipeRefreshLayout.setEnabled(true);
    }
}
