package quarter.com.lianxi.model;


import quarter.com.lianxi.bean.LoginBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 崔冬涛
 * 2018/01/23
 */

public interface ILoginModel {

    void login(String mobile, String password, OnNetLisenter<LoginBean> onNetLisenter);

}
