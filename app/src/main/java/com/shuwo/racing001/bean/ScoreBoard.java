package com.shuwo.racing001.bean;

/**
 * Created by asus01 on 2017/11/24.
 */

public class ScoreBoard {

//    {
//        "title": "2017年F1巴西站后车队积分榜",
//            "number": "1",
//            "chedui": "梅赛德斯",
//            "jifen": "625",
//            "page": 1
//    }

    private String title;
    private String number;
    private String chedui;
    private String jifen;
    private int page;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    public void setChedui(String chedui) {
        this.chedui = chedui;
    }
    public String getChedui() {
        return chedui;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }
    public String getJifen() {
        return jifen;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }


}
