package com.shuwo.racing001.present;

/**
 * Created by asus01 on 2017/10/17.
 */

public interface IBasePresent {

    void getInfoList(String ctl,int pageSize,String open);

    void getLoadMoreInfoList(String ctl,int pageSize,String open);

}
