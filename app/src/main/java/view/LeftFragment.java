package view;

import android.view.View;
import android.widget.TextView;

import java.util.List;

import domain.NewsCenterData;
import utils.PrintLog;

/**
 * 左侧菜单
 * Created by Miss on 2015/10/13.
 */
public class LeftFragment extends BaseFragment {

    /**
     * 2: 获取属性
     */
    private List<NewsCenterData.DataEntity> mLeftMenuData;

    @Override
    public View initView() {
        TextView tv = new TextView(mContext);
        tv.setText("LeftFragment");
        tv.setTextSize(30);

        return tv;
    }

    /**
     * 获取左侧菜单数据的 api
     * 1:设置左侧菜单数据,显示 data 四个值
     * 暴露 api 接收数据
     */
    public void setLeftMenuData(List<NewsCenterData.DataEntity> leftMenuData) {
        mLeftMenuData = leftMenuData;
        PrintLog.showLog(mLeftMenuData.get(0).getChildren().get(0).getUrl());
    }
}
