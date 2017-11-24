package com.shuwo.racing001.present.impl;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shuwo.racing001.Util.Contants;
import com.shuwo.racing001.Util.HttpClientUtil;
import com.shuwo.racing001.bean.News;
import com.shuwo.racing001.bean.ScoreResult;
import com.shuwo.racing001.http.AsyncHttpResponseHandler;
import com.shuwo.racing001.present.IBasePresent;
import com.shuwo.racing001.view.IBaseView;

import org.apache.http.Header;

import java.util.List;

/**
 * Created by asus01 on 2017/11/23.
 */

public class IScoreResultPresentImpl implements IBasePresent {

    private Context context;
    private IBaseView baseView;

    public IScoreResultPresentImpl(IBaseView baseView, Context context) {
        this.context = context;
        this.baseView = baseView;
    }

    @Override
    public void getInfoList(String ctl,int pageSize,String open) {
        String url = Contants.HTTP_BASE+ctl+"&size="+pageSize+"&open="+open;
        HttpClientUtil.getInstance(context).get(url,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String string = new String(responseBody);
                try {
                    if (string != null) {
                        Gson gson = new Gson();
                        List<ScoreResult> beanList = (List<ScoreResult>) gson.fromJson(string, new TypeToken<List<ScoreResult>>() {}.getType());
                        baseView.showInfoList(beanList);
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
    public void getLoadMoreInfoList(String ctl,int pageSize,String open) {
        String url = Contants.HTTP_BASE+ctl+"&size="+pageSize+"&open="+open;
        HttpClientUtil.getInstance(context).get(url,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String string = new String(responseBody);
                try {
                    if (string != null) {
                        Gson gson = new Gson();
                        List<ScoreResult> beanList = (List<ScoreResult>) gson.fromJson(string, new TypeToken<List<ScoreResult>>() {}.getType());
                        baseView.showLoadMoreInfoList(beanList);
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
