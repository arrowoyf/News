package pages;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miss.news.HomeActivity;
import com.example.miss.news.R;

/**
 * 5个页面的基类
 * @author Administrator
 *
 */
public class BasePage {
	protected HomeActivity mContext;
	private View rootView;
	
	protected TextView tv_title;
	protected ImageView iv_menu;
	protected FrameLayout fl_content;
	public BasePage(HomeActivity context){
		this.mContext = context;
		initView();
		initEvent();
	}
	private void initView(){
		rootView = View.inflate(mContext, R.layout.basepage_view, null);
		
		tv_title = (TextView) rootView.findViewById(R.id.tv_basepage_title);
		
		iv_menu = (ImageView) rootView.findViewById(R.id.iv_basepage_menu);
		
		fl_content = (FrameLayout) rootView.findViewById(R.id.fl_basepage_content);
	}
	
	public View getRootView(){
		return rootView;
	}
	
	public void initData(){
		
	}
	
	public void initEvent(){
		iv_menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//控制左侧菜单显示和关闭
				mContext.getSlidingMenu().toggle();
			}
		});
	}
}
