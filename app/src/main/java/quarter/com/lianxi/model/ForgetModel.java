package quarter.com.lianxi.model;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import quarter.com.lianxi.bean.ForgetBean;
import quarter.com.lianxi.net.HttpMethods;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/29.
 */

public class ForgetModel implements IForgetModel {
    @Override
    public void getPwd(String uid, String oldPwd, String newPwd, final OnNetLisenter<ForgetBean> onNetLisenter) {
        Map<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("oldPassword", oldPwd);
        map.put("newPassword", newPwd);
        HttpMethods.getInstnce().forget(map, new Consumer<ForgetBean>() {
            @Override
            public void accept(ForgetBean forgetBean) throws Exception {
                onNetLisenter.onSuccess(forgetBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                onNetLisenter.onDefault(throwable);
            }
        });
    }
}
