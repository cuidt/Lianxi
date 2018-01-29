package quarter.com.lianxi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22.
 */

public class TabTwoAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String titles[] = {"热门","附近"};

    public TabTwoAdapter(FragmentManager fm , List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    /**
     * 导航条上显示的标题栏字符串
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
