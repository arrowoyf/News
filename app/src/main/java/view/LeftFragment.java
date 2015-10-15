package view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miss.news.R;

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
    private ListView lv;
    private MyAdpter mAdpter;


    /**
     * 默认第一个条目被选中
     */
    private int selectIndex = 0;

    @Override
    public View initView() {
        lv = new ListView(mContext);

        /**设置 LeftMenu 背景属性：
         * 黑色背景
         * 无分割线
         * 选中的部分背景透明         *
         * 设置顶部间距
         */
        lv.setBackgroundColor(Color.BLACK);
        lv.setDividerHeight(0);
        lv.setSelector(new ColorDrawable((Color.TRANSPARENT)));
        lv.setPadding(20, 50, 0, 0);

        /**注意：NullPointException*/
        mAdpter = new MyAdpter();
        lv.setAdapter(mAdpter);
        return lv;
    }

    /**
     * 设置 tv 的选中状态
     */
    @Override
    public void initEvent() {
        /**给 lv 添加条目选择事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**选中条目时 设置 tv 为可用*/
                selectIndex = position;

                /**通知界面*/
                mAdpter.notifyDataSetChanged();
            }
        });
        super.initEvent();
    }

    private class MyAdpter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mLeftMenuData != null)
                return mLeftMenuData.size();
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(mContext, R.layout.item_leftmenu_lv, null);
            }
            TextView tv = (TextView) convertView;
            /**数据,*/
            String title = mLeftMenuData.get(position).getTitle();
            tv.setText(title);
            /**设置选中的位置可用*/
            if (selectIndex == position) {
                tv.setEnabled(true);
            } else {
                tv.setEnabled(false);
            }
            return tv;
        }
    }


    /**
     * 获取左侧菜单数据的 api
     * 1:设置左侧菜单数据,显示 data 四个值
     * 暴露 api 接收数据
     */
    public void setLeftMenuData(List<NewsCenterData.DataEntity> leftMenuData) {
        mLeftMenuData = leftMenuData;
        PrintLog.showLog(mLeftMenuData.get(0).getChildren().get(0).getUrl());
        /**界面 数据 都有，调用此处的方法，刷新数据*/
        mAdpter.notifyDataSetChanged();

        /**4：显示左侧菜单 ListView 数据*/

    }


}
