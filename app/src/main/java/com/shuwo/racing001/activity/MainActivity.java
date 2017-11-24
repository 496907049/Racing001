package com.shuwo.racing001.activity;

import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.shuwo.racing001.R;
import com.shuwo.racing001.fragment.HomePageFragment;
import com.shuwo.racing001.fragment.ScheduleFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    public static final int[] SAICHEIMG={
            R.drawable.saiche01, R.drawable.saiche02, R.drawable.saiche03, R.drawable.saiche04,R.drawable.saiche05,
            R.drawable.saiche06, R.drawable.saiche07, R.drawable.saiche08, R.drawable.saiche09, R.drawable.saiche10,
            R.drawable.saiche11, R.drawable.saiche12, R.drawable.saiche13, R.drawable.saiche14,R.drawable.saiche15,
            R.drawable.saiche16, R.drawable.saiche17, R.drawable.saiche18, R.drawable.saiche19, R.drawable.saiche20,
            R.drawable.saiche21, R.drawable.saiche22, R.drawable.saiche23, R.drawable.saiche24,R.drawable.saiche25,
            R.drawable.saiche26, R.drawable.saiche27, R.drawable.saiche28, R.drawable.saiche29, R.drawable.saiche30,
    };

    private BottomBar mBottomBar;

    private FragmentManager fragmentManager;
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private Fragment currentFragment = new Fragment();
    private List<Fragment> fragments = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomBar = (BottomBar) findViewById(R.id.main_bottombar);

        fragmentManager =getSupportFragmentManager();

        if (savedInstanceState != null) { // “内存重启”时调用
            //获取“内存重启”时保存的索引下标
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT,0);
            //注意，添加顺序要跟下面添加的顺序一样！！！！
            fragments.removeAll(fragments);
            fragments.add(fragmentManager.findFragmentByTag(0+""));
            fragments.add(fragmentManager.findFragmentByTag(1+""));
//            fragments.add(fragmentManager.findFragmentByTag(2+""));
//            fragments.add(fragmentManager.findFragmentByTag(3+""));
            //恢复fragment页面
            restoreFragment();

        }else{      //正常启动时调用
            fragments.add(new HomePageFragment());
            fragments.add(new ScheduleFragment());
//            fragments.add(new SpectatorsFragment());
//            fragments.add(new ForumFragment());
            showFragment();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        initBottomBar();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt(CURRENT_FRAGMENT,currentIndex);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void initBottomBar(){
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case com.shuwo.racing001.R.id.tab_home_page:
                        currentIndex = 0;
                        break;
                    case com.shuwo.racing001.R.id.tab_schedule:
                        currentIndex = 1;
                        break;
//                    case com.shuwo.racing001.R.id.tab_score_board:
//                        currentIndex = 2;
//                        break;
//                    case com.shuwo.racing001.R.id.tab_information:
//                        currentIndex = 3;
//                        break;
                }
                showFragment();
            }
        });
    }

    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    private void showFragment(){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //如果之前没有添加过
        if(!fragments.get(currentIndex).isAdded()){
            int a = currentIndex;
            transaction
                    .hide(currentFragment)
                    .add(R.id.fl_radio_show,fragments.get(currentIndex),""+currentIndex);  //第三个参数为添加当前的fragment时绑定一个tag
        }else{
            transaction
                    .hide(currentFragment)
                    .show(fragments.get(currentIndex));
        }
        currentFragment = fragments.get(currentIndex);
        transaction.commit();
    }

    /**
     * 恢复fragment
     */
    private void restoreFragment(){
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if(i == currentIndex){
                mBeginTreansaction.show(fragments.get(i));
            }else{
                mBeginTreansaction.hide(fragments.get(i));
            }
        }
        mBeginTreansaction.commit();
        //把当前显示的fragment记录下来
        currentFragment = fragments.get(currentIndex);
    }
}
