package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.LoginBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 崔冬涛
 * 2018/01/23
 */

public class LoginModel implements ILoginModel {
    @Override
    public void login(String mobile, String password, final OnNetLisenter<LoginBean> onNetLisenter) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", password);
        HttpMethods.getInstnce().login(map, new Consumer<LoginBean>() {
            @Override
            public void accept(LoginBean loginBean) throws Exception {
                onNetLisenter.onSuccess(loginBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
