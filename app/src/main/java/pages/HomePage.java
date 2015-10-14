package pages;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.miss.news.HomeActivity;


public class HomePage extends BasePage {

	public HomePage(HomeActivity context) {
		super(context);
	}

	@Override
	public void initData() {
		//隐藏menu
		iv_menu.setVisibility(View.GONE);
		tv_title.setText("首页");
		// 内容
		TextView tv = new TextView(mContext);
		tv.setText("首页的内容");
		tv.setTextSize(30);
		tv.setGravity(Gravity.CENTER);

		// 添加到内容中frameLayout
		fl_content.addView(tv);
	}

}
