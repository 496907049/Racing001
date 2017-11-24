package com.shuwo.racing001.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shuwo.racing001.R;
import com.shuwo.racing001.Util.RandomUtils;
import com.shuwo.racing001.Util.TextLengthUtil;
import com.shuwo.racing001.Util.ToastUtils;
import com.shuwo.racing001.Util.Utils;
import com.shuwo.racing001.activity.MainActivity;
import com.shuwo.racing001.bean.News;
import com.shuwo.racing001.bean.ScoreResult;

import java.util.List;

/**
 * Created by asus01 on 2017/9/22.
 */

public class ScoreResultAdapter extends BaseQuickAdapter<ScoreResult, BaseViewHolder> {

    int[] img ={R.mipmap.gold_medal,R.mipmap.silver_medal,R.mipmap.bronze_medal};

    public ScoreResultAdapter(@LayoutRes int layoutResId, @Nullable List<ScoreResult> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ScoreResult item) {
        helper.setText(R.id.tv_number,item.getNumber());
        helper.setText(R.id.tv_country, item.getGuoji());
        helper.setText(R.id.tv_diver_name, item.getCheshou());
        helper.setText(R.id.tv_fleet_name, item.getChedui());
        helper.setText(R.id.tv_integral, item.getBenzhanjifen());


        switch (item.getNumber()){
            case "1":
                helper.setGone(R.id.iv_medal,true);
                Glide.with(mContext).load(img[0]).crossFade().into((ImageView) helper.getView(R.id.iv_medal));
                break;
            case "2":
                helper.setGone(R.id.iv_medal,true);
                Glide.with(mContext).load(img[1]).crossFade().into((ImageView) helper.getView(R.id.iv_medal));
                break;
            case "3":
                helper.setGone(R.id.iv_medal,true);
                Glide.with(mContext).load(img[2]).crossFade().into((ImageView) helper.getView(R.id.iv_medal));
                break;
            default:
                helper.setGone(R.id.iv_medal,false);
                break;
        }

    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.my_yellow));
            ds.setUnderlineText(true);
        }
    };
}

