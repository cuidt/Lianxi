package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.PublishBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public class PublishModel implements IPublishModel {
    @Override
    public void getPublish(String token, String uid, String content, final OnNetLisenter<PublishBean> onNetLisenter) {
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("uid", uid);
        map.put("content", content);
        map.put("source", "android");
        map.put("appVersion", "101");
        HttpMethods.getInstnce().publish(map, new Consumer<PublishBean>() {
            @Override
            public void accept(PublishBean publishBean) throws Exception {
                onNetLisenter.onSuccess(publishBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }


}
