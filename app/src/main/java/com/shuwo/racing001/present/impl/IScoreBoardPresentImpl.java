package com.shuwo.racing001.present.impl;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shuwo.racing001.Util.Contants;
import com.shuwo.racing001.Util.HttpClientUtil;
import com.shuwo.racing001.bean.ScoreBoard;
import com.shuwo.racing001.http.AsyncHttpResponseHandler;
import com.shuwo.racing001.present.IScoreBoardPresent;
import com.shuwo.racing001.view.IScoreBoardView;

import org.apache.http.Header;

import java.util.List;

/**
 * Created by asus01 on 2017/11/23.
 */

public class IScoreBoardPresentImpl implements IScoreBoardPresent {

    private Context context;
    private IScoreBoardView scoreBoardView;

    public IScoreBoardPresentImpl(IScoreBoardView scoreBoardView, Context context) {
        this.context = context;
        this.scoreBoardView = scoreBoardView;
    }


    @Override
    public void getScoreBoardList(String ctl) {
        String url = Contants.HTTP_BASE+ctl;
        HttpClientUtil.getInstance(context).get(url,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String string = new String(responseBody);
                try {
                    if (string != null) {
                        Gson gson = new Gson();
                        List<ScoreBoard> beanList = (List<ScoreBoard>) gson.fromJson(string, new TypeToken<List<ScoreBoard>>() {}.getType());
                        scoreBoardView.showScoreboardList(beanList);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(context, "操作失败", Toast.LENGTH_LONG);
            }
        });

    }

    @Override
    public void getLoadMoreScoreBoardList(String ctl) {
        String url = Contants.HTTP_BASE+ctl;
        HttpClientUtil.getInstance(context).get(url,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String string = new String(responseBody);
                try {
                    if (string != null) {
                        Gson gson = new Gson();
                        List<ScoreBoard> beanList = (List<ScoreBoard>) gson.fromJson(string, new TypeToken<List<ScoreBoard>>() {}.getType());
                        scoreBoardView.showLoadMoreScoreboardList(beanList);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(context, "操作失败", Toast.LENGTH_LONG);
            }
        });

    }
}
