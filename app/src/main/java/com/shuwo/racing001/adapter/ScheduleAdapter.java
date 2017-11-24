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
import com.shuwo.racing001.bean.Schedule;

import java.util.List;

/**
 * Created by asus01 on 2017/9/22.
 */

public class ScheduleAdapter extends BaseQuickAdapter<Schedule, BaseViewHolder> {


    public ScheduleAdapter(@LayoutRes int layoutResId, @Nullable List<Schedule> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Schedule item) {
        helper.setText(R.id.tv_station_name,item.getRace());
        helper.setText(R.id.tv_time,item.getTime());
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

