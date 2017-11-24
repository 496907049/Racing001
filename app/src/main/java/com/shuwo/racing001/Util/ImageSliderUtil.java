package com.shuwo.racing001.Util;

import android.content.Context;
import android.view.View;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.shuwo.racing001.R;
import com.shuwo.racing001.widget.MyTextSliderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus01 on 2017/10/20.
 */

public class ImageSliderUtil{

    private static  View imageSliderView;
    private static SliderLayout sliderLayout;
    private static PagerIndicator indicator;

    public static View initImageSlider(Context context) {
         imageSliderView = View.inflate(context, R.layout.fragment_imge_slider, null);
         sliderLayout = (SliderLayout) imageSliderView.findViewById(R.id.slider);
         indicator = (PagerIndicator) imageSliderView.findViewById(R.id.custom_indicator);
        //准备好要显示的数据
        List<Integer> imageUrls = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
            imageUrls.add(R.mipmap.banner1);
            imageUrls.add(R.mipmap.banner2);
            imageUrls.add(R.mipmap.banner3);
            descriptions.add(" ");
            descriptions.add(" ");
            descriptions.add(" ");
        for (int i = 0; i < imageUrls.size(); i++) {
            //新建三个展示View，并且添加到SliderLayout
            MyTextSliderView tsv = new MyTextSliderView(context);
            tsv.image(imageUrls.get(i)).description(descriptions.get(i));
            final int finalI = i;
            tsv.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
//                    Toast.makeText(getActivity(), descriptions.get(finalI), Toast.LENGTH_SHORT).show();
                }
            });
            sliderLayout.addSlider(tsv);
        }

        //对SliderLayout进行一些自定义的配置
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setDuration(3000);
        //      sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomIndicator(indicator);

        return imageSliderView;
    }

}
