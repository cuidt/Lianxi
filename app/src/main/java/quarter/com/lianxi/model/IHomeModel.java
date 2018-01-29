package quarter.com.lianxi.model;

import quarter.com.lianxi.bean.HomeBean;
import quarter.com.lianxi.net.OnNetLisenter;
/**
 * 崔冬涛
 * 2018/01/23
 */
public interface IHomeModel {

    void getHome(OnNetLisenter<HomeBean> onNetLisenter);

}