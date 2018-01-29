package quarter.com.lianxi.view;

import quarter.com.lianxi.bean.PublishBean;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public interface IPublishView {
    String getToken();
    String getcontent();
    String getUid();
    void setPublishBean(PublishBean publishBean);

}
