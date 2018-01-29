package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.CrossBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/24.
 */

public class CrossModel implements ICrossModel {
    @Override
    public void getCross(String token, final OnNetLisenter<CrossBean> onNetLisenter) {
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("source","android");
        map.put("appVersion","101");
        int x=(int)(Math.random()*20);
        map.put("page",x+"");
        HttpMethods.getInstnce().cross(map, new Consumer<CrossBean>() {
            @Override
            public void accept(CrossBean crossBean) throws Exception {
                onNetLisenter.onSuccess(crossBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
