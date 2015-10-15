package pages;

import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miss.news.HomeActivity;
import com.example.miss.news.R;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import domain.NewsCenterData;
import utils.PrintLog;
import view.LeftFragment;


public class NewsCenterPage extends BasePage {

    private NewsCenterData newsCenterData;

    public NewsCenterPage(HomeActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        tv_title.setText("新闻中心");

        // 内容
        TextView tv = new TextView(mContext);
        tv.setText("新闻中心的内容");
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);

        // 添加到内容中frameLayout
        fl_content.addView(tv);


        /**从服务器获取数据*/
        String url = mContext.getResources().getString(R.string.newscenterurl);
        /**1：请求 url,从网络上获取数据*/
        getDataForNet(url);


    }

    /**
     * 从服务器获取数据
     *
     * @param url
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
     * @param newsCenterData
     */
    private void processData(NewsCenterData newsCenterData) {

        PrintLog.showLog(newsCenterData.getData().get(0).getChildren().get(0).getTitle());

        /**3：设置左侧菜单数据
         *  获取菜单数据的 api 已被暴露，
         *  目的：只需获取 leftfragment 即可
         *  NewsCenter 想要获取到 LeftFragment 通过 HomeActivity
         */
        /**获取*/
        LeftFragment leftFragment = mContext.getLeftFragment();
        leftFragment.setLeftMenuData(newsCenterData.getData());
        /**设置四个新闻界面*/

        /**显示数据*/


    }

    /**
     * 解析 json 数据
     *
     * @param jsonDataStr
     */
    private NewsCenterData parseJsonData(String jsonDataStr) {
        Gson gson = new Gson();
        /**1,创建 class，根据 Bean 解析数据*/
        NewsCenterData newsCenterData = gson.fromJson(jsonDataStr, NewsCenterData.class);

        return newsCenterData;
    }

}
