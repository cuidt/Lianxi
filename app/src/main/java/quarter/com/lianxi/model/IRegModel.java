package quarter.com.lianxi.model;


import quarter.com.lianxi.bean.RegBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 崔冬涛
 * 2018/01/23
 */

public interface IRegModel {

    void reg(String mobile, String password, OnNetLisenter<RegBean> onNetLisenter);


}
