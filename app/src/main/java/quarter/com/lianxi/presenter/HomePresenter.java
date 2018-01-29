package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.HomeBean;
import quarter.com.lianxi.model.HomeModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.IHomeView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */

public class HomePresenter {
    private IHomeView view;
    private HomeModel model;


    public HomePresenter(IHomeView view) {
        this.view = view;
        model = new HomeModel();
    }

    public void home() {
        model.getHome(new OnNetLisenter<HomeBean>() {
            @Override
            public void onSuccess(HomeBean bean) {
                view.setHomeBean(bean);
            }

            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();

            }
        });
    }
}
