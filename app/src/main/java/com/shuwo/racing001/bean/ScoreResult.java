package com.shuwo.racing001.bean;

/**
 * Created by asus01 on 2017/11/24.
 */

public class ScoreResult {

//    {
//        "title": "2017赛季F1巴西站正式比赛成绩表",
//                "number": "1",
//                "chehao": "5",
//                "cheshou": "维泰尔",
//                "guoji": "德国",
//                "chedui": "法拉利",
//                "chengji": "1h31m26.262s",
//                "benzhanjifen": "25",
//                "page": 1
//    }

    private String title;
    private String number;
    private String chehao;
    private String cheshou;
    private String guoji;
    private String chedui;
    private String chengji;
    private String benzhanjifen;
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

    public void setChehao(String chehao) {
        this.chehao = chehao;
    }
    public String getChehao() {
        return chehao;
    }

    public void setCheshou(String cheshou) {
        this.cheshou = cheshou;
    }
    public String getCheshou() {
        return cheshou;
    }

    public void setGuoji(String guoji) {
        this.guoji = guoji;
    }
    public String getGuoji() {
        return guoji;
    }

    public void setChedui(String chedui) {
        this.chedui = chedui;
    }
    public String getChedui() {
        return chedui;
    }

    public void setChengji(String chengji) {
        this.chengji = chengji;
    }
    public String getChengji() {
        return chengji;
    }

    public void setBenzhanjifen(String benzhanjifen) {
        this.benzhanjifen = benzhanjifen;
    }
    public String getBenzhanjifen() {
        return benzhanjifen;
    }

    public void setPage(int page) {
        this.page = page;
    }
    public int getPage() {
        return page;
    }



}
