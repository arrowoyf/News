package newscenterpages;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.miss.news.HomeActivity;

/**
 * 互动的内容
 *      --by 新闻中心
 * Created by Miss on 2015/10/15.
 */
public class InterectPage_NewsCenter extends BaseNewsCenterPage {

    /**
     * 构造函数
     *
     * @param context
     */
    public InterectPage_NewsCenter(HomeActivity context) {
        super(context);
    }



    @Override
    public View initView() {
        TextView tv = new TextView(mContext);
        tv.setText("互动的内容----");
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);

        return tv;
    }
}
