package com.shuwo.racing001.bean;

/**
 * Created by asus01 on 2017/11/24.
 */

public class Schedule {

//    {
//        "title": "2017年F1赛程",
//            "time": "3月26日",
//            "race": "澳大利亚站",
//            "page": 1
//    }

    private String title;
    private String time;
    private String race;
    private int page;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setRace(String race) {
        this.race = race;
    }
    public String getRace() {
        return race;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }

}
