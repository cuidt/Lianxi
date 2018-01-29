package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.RegBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */

public class RegModel implements IRegModel {
    @Override
    public void reg(String mobile, String password, final OnNetLisenter<RegBean> onNetLisenter) {
        Map<String,String> map= new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        HttpMethods.getInstnce().reg(map, new Consumer<RegBean>() {
            @Override
            public void accept(RegBean regBean) throws Exception {
                onNetLisenter.onSuccess(regBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
