package view;

import android.view.View;
import android.widget.TextView;

/**
 * 左侧菜单
 * Created by Miss on 2015/10/13.
 */
public class LeftFragment extends BaseFragment{
    @Override
    public View initView() {
        TextView tv = new TextView(mContext);
        tv.setText("LeftFragment");
        tv.setTextSize(30);

        return tv;
    }
}
