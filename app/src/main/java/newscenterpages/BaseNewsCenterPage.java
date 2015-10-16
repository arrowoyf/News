package newscenterpages;

import android.view.View;

import com.example.miss.news.HomeActivity;

/**
 * 新闻中心的，基类抽取
 *
 * 创建基类
 * 定义抽象方法自己去实现 view
 * 目的：
 *
 * Created by Miss on 2015/10/15.
 * 界面 事件 数据
 */
public abstract class BaseNewsCenterPage {
    /**
     * 1，获取上下文
     * 父类上下文，暴露给子类， protected 访问权限
     */
    protected HomeActivity mContext;

    /**
     * 根布局，
     */
    private View rootView;

    /**
     * 构造函数
     *
     * @param context 传入上下文
     */
    public BaseNewsCenterPage(HomeActivity context) {
        mContext = context;

        rootView = initView();
        initEvent();
    }

    private void initEvent() {

    }


    public abstract View initView();

    public View getRootView() {
        return rootView;
    }

    public void initData() {

    }
}
