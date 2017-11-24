package com.shuwo.racing001.view;

import com.shuwo.racing001.bean.ScoreBoard;

import java.util.List;

/**
 * Created by asus01 on 2017/11/24.
 */

public interface IScoreBoardView{

    void showScoreboardList(List<ScoreBoard> scoreList);
    void showLoadMoreScoreboardList(List<ScoreBoard> scoreList);

}
