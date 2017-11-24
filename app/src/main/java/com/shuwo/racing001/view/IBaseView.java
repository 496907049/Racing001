package com.shuwo.racing001.view;

import java.util.List;

/**
 * Created by asus01 on 2017/11/14.
 */

public interface IBaseView<T> {

    void showInfoList(List<T> infoList);

    void showLoadMoreInfoList(List<T> infoList);

}
