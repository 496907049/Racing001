package com.shuwo.racing001.Util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shuwo.racing001.R;
import com.shuwo.racing001.activity.NewsActivity;
import com.shuwo.racing001.activity.ScoreResultActivity;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus01 on 2017/11/15.
 */

public class HorseRaceLampUtil{

    public static View getHorseRaceLamp(final Context context, List<String> stringList) {

        View view = LayoutInflater.from(context).inflate(R.layout.horse_race_lamp, null);

        RelativeLayout moreLL = (RelativeLayout) view.findViewById(R.id.horse_more);
        moreLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,NewsActivity.class);
                intent.putExtra("title","新闻");
                context.startActivity(intent);
            }
        });


        MarqueeView marqueeView = (MarqueeView) view.findViewById(R.id.marqueeView);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Intent intent = new Intent(context,ScoreResultActivity.class);
                intent.putExtra("title","选手成绩榜");
                context.startActivity(intent);
            }
        });
        List<String> info = new ArrayList<>();
        info.addAll(stringList);
        marqueeView.startWithList(info);
        // 在代码里设置自己的动画
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);
        return view;
    }

}
