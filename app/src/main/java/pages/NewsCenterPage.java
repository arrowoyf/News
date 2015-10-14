package pages;

import android.view.Gravity;
import android.widget.TextView;

import com.example.miss.news.HomeActivity;


public class NewsCenterPage extends BasePage {

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
	}

}
