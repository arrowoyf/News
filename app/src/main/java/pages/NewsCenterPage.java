package pages;

import android.view.View;
import android.widget.Toast;

import com.example.miss.news.HomeActivity;
import com.example.miss.news.R;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

import domain.NewsCenterData;
import newscenterpages.BaseNewsCenterPage;
import newscenterpages.InterectPage_NewsCenter;
import newscenterpages.NewsPage_NewsCenter;
import newscenterpages.PhotoPage_NewsCenter;
import newscenterpages.TopicPage_NewsCenter;
import utils.PrintLog;
import view.LeftFragment;


public class NewsCenterPage extends BasePage {

    /**
     * 新闻中心，显示 4 个页面
     * 设置一个容器类
     */
    private List<BaseNewsCenterPage> mBaseNewsCenterPages = new ArrayList<>();


    private NewsCenterData newsCenterData;

    public NewsCenterPage(HomeActivity context) {
        super(context);
    }


    /**
     * 设置显示新闻条目对应的uemian
     *
     * @param pageIndex 新闻 专题 。。。
     *                  关联：点击事件
     */
    @Override
    public void selectPage(int pageIndex) {
        /***/
        PrintLog.showLog("页面" + pageIndex + "的显示");

        changPage(pageIndex);

    }

    /**
     * 页面的切换
     *
     * @param pageIndex 索引值
     */
    private void changPage(int pageIndex) {
        viewDatas(pageIndex);
    }


    @Override
    public void initData() {


        /**从服务器获取数据*/
        String url = mContext.getResources().getString(R.string.newscenterurl);
        /**1：请求 url,从网络上获取数据*/
        getDataForNet(url);


    }

    /**
     * 从服务器获取数据
     *
     * @param url 地址
     */
    private void getDataForNet(String url) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                PrintLog.showLog("请求数据成功");


                /**请求成功*/

                /**2：获取 json 数据*/
                String jsonDataStr = responseInfo.result;
                /**3：解析 json 数据*/
                newsCenterData = parseJsonData(jsonDataStr);
                /**4：处理数据*/
                processData(newsCenterData);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                /**请求失败*/
                Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 处理数据
     *
     * @param newsCenterData json 数据
     */
    private void processData(NewsCenterData newsCenterData) {

        PrintLog.showLog(newsCenterData.getData().get(0).getChildren().get(0).getTitle());
        /**3：设置左侧菜单数据
         */
        setLeftMenuData(newsCenterData);


        /**设置四个新闻界面,新闻 专题 组图 互动
         * 1，按顺序，暴露的接口有顺序
         * 2，左侧菜单 ListView 显示数据和  domain 数据保持一致
         */
        initNewsPages(newsCenterData);

        /**显示数据*/
        viewDatas(0);


    }

    /**
     * @param index 获取要显示数据的位置
     */
    private void viewDatas(int index) {
        tv_title.setText(newsCenterData.getData().get(index).getTitle());

        /**内容加载帧布局中，加载之前，先清空*/
        fl_content.removeAllViews();

        /**获取当前显示的 View*/
        View v = mBaseNewsCenterPages.get(index).getRootView();
        PrintLog.showLog("v 0= "+mBaseNewsCenterPages);
        PrintLog.showLog("v 1= "+mBaseNewsCenterPages.get(index));
        PrintLog.showLog("v 2 = "+mBaseNewsCenterPages.get(index).getRootView());


        /**添加到内容 Fragment*/
        fl_content.addView(v);


    }

    /**
     * 创建 4 个页面
     *
     * @param newsCenterData
     */
    private void  initNewsPages(NewsCenterData newsCenterData) {
        /**取数据*/
        for (NewsCenterData.DataEntity data : newsCenterData.getData()) {
            /**迭代 数据内容,根据 type 的值，保持有序性*/
            int type = data.getType();
            switch (type) {
                case 1:
                    /**新闻*/
                    mBaseNewsCenterPages.add(new NewsPage_NewsCenter(mContext));

                    break;
                case 10:
                    /**专题*/
                    mBaseNewsCenterPages.add(new TopicPage_NewsCenter(mContext));

                    break;
                case 2:
                    /**组图*/
                    mBaseNewsCenterPages.add(new PhotoPage_NewsCenter(mContext));

                    break;
                case 3:
                    /**互动*/
                    mBaseNewsCenterPages.add(new InterectPage_NewsCenter(mContext));

                    break;
                default:
                    break;

            }
        }
    }


    private void setLeftMenuData(NewsCenterData newsCenterData) {
        /**3：设置左侧菜单数据
         *  获取菜单数据的 api 已被暴露，
         *  目的：只需获取 leftfragment 即可
         *  NewsCenter 想要获取到 LeftFragment 通过 HomeActivity
         */
        /**获取*/
        LeftFragment leftFragment = mContext.getLeftFragment();
        leftFragment.setLeftMenuData(newsCenterData.getData());

        leftFragment.setOnLeftMenuPageChangeListener(new LeftFragment.OnLeftMenuPageChangeListener() {
            @Override
            public void selectPage(int selectIndex) {
                PrintLog.showLog("桥：页面" + selectIndex + "的显示");

                changPage(selectIndex);


            }
        });
    }

    /**
     * 解析 json 数据
     *
     * @param jsonDataStr json数据的解析
     */
    private NewsCenterData parseJsonData(String jsonDataStr) {
        Gson gson = new Gson();
        /**1,创建 class，根据 Bean 解析数据*/
        NewsCenterData newsCenterData = gson.fromJson(jsonDataStr, NewsCenterData.class);

        return newsCenterData;
    }

}
