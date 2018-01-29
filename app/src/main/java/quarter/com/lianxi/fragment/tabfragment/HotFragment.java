package quarter.com.lianxi.fragment.tabfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.HomeBean;
import quarter.com.lianxi.presenter.HomePresenter;
import quarter.com.lianxi.util.FrescoImageLoader;
import quarter.com.lianxi.view.IHomeView;

/**
 * 热门页面
 */
public class HotFragment extends Fragment implements IHomeView {

    @BindView(R.id.banner)
    Banner banner;
    Unbinder unbinder;
    private ArrayList<String> imgs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        HomePresenter presenter = new HomePresenter(this);
        presenter.home();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setHomeBean(HomeBean bean) {
        //播放banner轮播图
        imgs = new ArrayList<>();
        List<HomeBean.DataBean> data = bean.getData();
        for (int i = 0; i < data.size(); i++) {
            imgs.add(data.get(i).getIcon());
        }

        banner.setImages(imgs);
        banner.setDelayTime(3000);
        //Banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        banner.setImageLoader(new FrescoImageLoader());
    }


}
