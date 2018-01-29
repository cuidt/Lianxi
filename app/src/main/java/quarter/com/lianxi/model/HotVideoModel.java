package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public class HotVideoModel implements IHotVideoModel {

    @Override
    public void getHotvideo(String token, final OnNetLisenter<HotVideoBean> onNetLisenter) {
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("source", "android");
        map.put("appVersion", "101");
        HttpMethods.getInstnce().hotvideo(map, new Consumer<HotVideoBean>() {
            @Override
            public void accept(HotVideoBean hotVideoBean) throws Exception {
                onNetLisenter.onSuccess(hotVideoBean);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
