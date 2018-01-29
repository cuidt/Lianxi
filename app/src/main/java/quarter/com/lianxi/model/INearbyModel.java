package quarter.com.lianxi.model;

import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public interface INearbyModel {

        void getNearbyVideo(String token, OnNetLisenter<NearbyVideoBean> onNetLisenter);

}
