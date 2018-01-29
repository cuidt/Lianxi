package quarter.com.lianxi.model;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.HomeBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */

public class HomeModel implements IHomeModel {
    @Override
    public void getHome(final OnNetLisenter<HomeBean> onNetLisenter) {
        HttpMethods.getInstnce().getHome(new Consumer<HomeBean>() {
            @Override
            public void accept(HomeBean homeBean) throws Exception {
                onNetLisenter.onSuccess(homeBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
