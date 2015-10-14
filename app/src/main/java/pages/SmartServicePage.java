package pages;

import android.view.Gravity;
import android.widget.TextView;

import com.example.miss.news.HomeActivity;


public class SmartServicePage extends BasePage {

    public SmartServicePage(HomeActivity context) {
        super(context);
    }

    @Override
    public void initData() {
        tv_title.setText("智慧服务");
        // 内容
        TextView tv = new TextView(mContext);
        tv.setText("智慧服务的内容");
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);

        // 添加到内容中frameLayout
        fl_content.addView(tv);
    }

}
