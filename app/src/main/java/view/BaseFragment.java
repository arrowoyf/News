package view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miss.news.HomeActivity;

/**
 * Fragment 的基类 生命周期图
 * Created by Miss on 2015/10/14.
 * 界面 数据 事件
 */

public abstract class BaseFragment extends Fragment {

    protected HomeActivity mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        /**每个界面都需要上下文，获取上下文，get 依附的 Activity*/
        mContext = (HomeActivity) getActivity();
        super.onCreate(savedInstanceState);
    }

    /**
     * 获取 view
     * 子类自己去实现 view
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return initView();
    }


    public abstract View initView();

    /**
     * 子类覆盖此方法完成数据的初始化
     */
    public void initData() {

    }

    /**
     * 子类覆盖此方法完成事件的设置
     */
    public void initEvent() {

    }

    /**
     * 此处调用 以上方法，初始化数据，事件
     */
    @Override
    public void onStart() {
        initData();
        initEvent();
        super.onStart();
    }
}
