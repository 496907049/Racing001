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
import java.util.List;

/**
 * Created by asus01 on 2017/9/22.
 */

public class TwoTextLeftAndOneImgRightAdapter extends BaseQuickAdapter<News, BaseViewHolder> {


    public TwoTextLeftAndOneImgRightAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        helper.setText(R.id.tv_time,item.getTime());
        helper.setText(R.id.tv_title, TextLengthUtil.textLengthTo25(item.getTitle()));

        if(!item.getPicture().equals("h")){
            // 加载网络图片
            Glide.with(mContext).load(item.getPicture()).crossFade().into((ImageView) helper.getView(R.id.iv_icon)
                    );
        }else {
            Glide.with(mContext).load(MainActivity.SAICHEIMG[RandomUtils.getRandom(0,MainActivity.SAICHEIMG.length)]).crossFade().into((ImageView) helper.getView(R.id.iv_icon)
                    );
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

