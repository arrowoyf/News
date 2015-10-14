package com.example.miss.news;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by Miss on 2015/10/12.
 */
public class HomeActivity extends SlidingFragmentActivity {

    private static final String LEFT_FRAGMENT = "left_fragment";
    private static final String MAIN_FRAGMENT = "main_fragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        initData();
    }

    private void initData() {
    }


    private void initView() {
        /**左侧菜单布局*/
        setBehindContentView(R.layout.left_menu);

        /**内容布局*/
        setContentView(R.layout.content);

        SlidingMenu slidingMenu = getSlidingMenu();

        /**左侧菜单显示完全后剩余的宽度*/
        slidingMenu.setBehindOffset(200);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        /**.setMode(SlidingMenu.LEFT_RIGHT);*/
        slidingMenu.setMode(SlidingMenu.LEFT);

    }
}
