package com.shuwo.racing001.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shuwo.racing001.R;
import com.shuwo.racing001.Util.RandomUtils;
import com.shuwo.racing001.http.Base64;

/**
 * Created by asus01 on 2017/11/14.
 */

public class BodyActivity extends AppCompatActivity {

    private String bodys;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText("详情");
        RelativeLayout backRL = (RelativeLayout) findViewById(R.id.rl_back);
        backRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //从Intent当中根据key取得value
        Intent intent = getIntent();
        if (intent != null) {
            bodys = intent.getStringExtra("body");
        }

        TextView body = (TextView) findViewById(R.id.content_text);
        body.setText(""+ new String(Base64.decode(bodys,1)));

        ImageView picture = (ImageView) findViewById(R.id.content_picture);
        // 加载网络图片
        Glide.with(this).load(MainActivity.SAICHEIMG[RandomUtils.getRandom(0,MainActivity.SAICHEIMG.length)]).into(picture);


    }
}
