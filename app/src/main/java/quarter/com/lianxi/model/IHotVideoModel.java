package quarter.com.lianxi.model;

import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public interface IHotVideoModel {

    void getHotvideo(String token, OnNetLisenter<HotVideoBean> onNetLisenter);

}
