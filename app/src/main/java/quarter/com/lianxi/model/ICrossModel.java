package quarter.com.lianxi.model;

import quarter.com.lianxi.bean.CrossBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/24.
 */

public interface ICrossModel {

    void getCross(String token , OnNetLisenter<CrossBean> onNetLisenter);

}
