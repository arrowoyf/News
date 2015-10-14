package view;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.miss.news.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import pages.BasePage;
import pages.GovAffairsPage;
import pages.HomePage;
import pages.NewsCenterPage;
import pages.SettingCenterPage;
import pages.SmartServicePage;

/**
 * 内容
 * Created by Miss on 2015/10/13.
 */
public class MainFragment extends BaseFragment {
    /**
     * 声明组件
     */
    @ViewInject(R.id.vp_mainfragment_page)
    private ViewPager viewPager;

    /**
     * RadioButton
     */
    @ViewInject(R.id.rg_radios)
    private RadioGroup rg_radios;
    private List<BasePage> pages = new ArrayList<>();

    @Override
    public View initView() {

        View root = View.inflate(mContext, R.layout.main_content, null);
        /**注入*/
        ViewUtils.inject(this, root);

        return root;
    }

    private class MyAdpter extends PagerAdapter {

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePage page = pages.get(position);
            View view = page.getRootView();
            /**初始化数据*/
            page.initData();
            container.addView(view);
            return view;
        }
    }

    @Override
    public void initData() {
        /**默认选中的rb*/
        rg_radios.
                check(R.id.rb_home);
        /**添加五个页面*/
        pages.add(new HomePage(mContext));
        pages.add(new NewsCenterPage(mContext));
        pages.add(new SmartServicePage(mContext));
        pages.add(new GovAffairsPage(mContext));
        pages.add(new SettingCenterPage(mContext));

        /**绑定适配器*/
        MyAdpter adpter = new MyAdpter();
        viewPager.setAdapter(adpter);
        switchPages();
        super.initData();
    }

    private int selectIndex = 0;


    /**
     * 事件设置
     */
    @Override
    public void initEvent() {
        rg_radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        selectIndex = 0;
                        break;
                    case R.id.rb_news:
                        selectIndex = 1;
                        break;
                    case R.id.rb_smartservice:
                        selectIndex = 2;
                        break;
                    case R.id.rb_govaffiar:
                        selectIndex = 3;
                        break;
                    case R.id.rb_settingcenter:
                        selectIndex = 4;
                        break;

                    default:
                        break;
                }
                switchPages();
            }
        });
        super.initEvent();
    }

    private void switchPages() {
        viewPager.setCurrentItem(selectIndex);

        /**左侧菜单是否可以拖动*/
        /**第一个和最后一个不能拖动左侧菜单*/
        if (selectIndex == 0 || selectIndex == 4) {
            mContext.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        } else {
            mContext.getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }
    }
}
