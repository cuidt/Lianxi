package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public class NearbyModel implements INearbyModel {
    @Override
    public void getNearbyVideo(String token, final OnNetLisenter<NearbyVideoBean> onNetLisenter) {
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
       /* map.put("source", "android");
        map.put("appVersion", "101");*/
        map.put("latitude", "39.95");
        map.put("longitude", "116.30");
        HttpMethods.getInstnce().nearbyvideo(map, new Consumer<NearbyVideoBean>() {
            @Override
            public void accept(NearbyVideoBean nearbyVideoBean) throws Exception {
                onNetLisenter.onSuccess(nearbyVideoBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
