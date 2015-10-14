package pages;

import android.view.Gravity;
import android.widget.TextView;

import com.example.miss.news.HomeActivity;


public class GovAffairsPage extends BasePage {

	public GovAffairsPage(HomeActivity context) {
		super(context);
	}
	
	@Override
	public void initData() {
		tv_title.setText("政务");
		
		//内容
		TextView tv = new TextView(mContext);
		tv.setText("政务的内容");
		tv.setTextSize(30);
		tv.setGravity(Gravity.CENTER);
		
		//添加到内容中frameLayout
		fl_content.addView(tv);
	}

}
