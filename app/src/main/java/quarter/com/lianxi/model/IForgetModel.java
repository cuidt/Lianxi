package quarter.com.lianxi.model;

import quarter.com.lianxi.bean.ForgetBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/29.
 */

public interface IForgetModel {

    void getPwd(String uid,String oldPwd, String newPwd, OnNetLisenter<ForgetBean> onNetLisenter);

}
