package com.example.miss.news;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import view.LeftFragment;
import view.MainFragment;

/**
 * 内容
 * Created by Miss on 2015/10/12.
 */
public class HomeActivity extends SlidingFragmentActivity {

    private static final String LEFT_FRAGMENT = "left_fragment";
    private static final String MAIN_FRAGMENT = "main_fragment";
    private FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        initData();
    }

    /**
     * Fragment 的替换
     */
    private void initData() {
        /**获取Fragment的管理器*/
        fragmentManager = getSupportFragmentManager();

        /**开始事物*/
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        /**替换,两个标记*/
        fragmentTransaction.replace(R.id.fl_left_menu, new LeftFragment(), LEFT_FRAGMENT);
        fragmentTransaction.replace(R.id.fl_content, new MainFragment(), MAIN_FRAGMENT);

        /**提交事物*/
        fragmentTransaction.commit();
    }

    public LeftFragment getLeftFragment() {
        return (LeftFragment) fragmentManager.getFragment(null, LEFT_FRAGMENT);
    }

    public MainFragment getMainFragment() {
        return (MainFragment) fragmentManager.getFragment(null, MAIN_FRAGMENT);
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
