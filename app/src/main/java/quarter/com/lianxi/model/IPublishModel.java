package quarter.com.lianxi.model;

import quarter.com.lianxi.bean.PublishBean;
import quarter.com.lianxi.net.OnNetLisenter;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public interface IPublishModel  {

    void getPublish(String token,String uid,String content, OnNetLisenter<PublishBean> onNetLisenter);

}
