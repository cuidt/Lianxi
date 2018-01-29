package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.PublishBean;
import quarter.com.lianxi.model.PublishModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.IPublishView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public class PublishPresenter {
    IPublishView iPublishView;
    PublishModel publishModel;

    public PublishPresenter(IPublishView iPublishView) {
        this.iPublishView = iPublishView;
        publishModel = new PublishModel();
    }

    public void getPublish() {
        String token = iPublishView.getToken();
        String uid = iPublishView.getUid();
        String content = iPublishView.getcontent();
        publishModel.getPublish(token, uid, content, new OnNetLisenter<PublishBean>() {
            @Override
            public void onSuccess(PublishBean publishBean) {
                if (publishBean.getCode().equals("0")) {
                    iPublishView.setPublishBean(publishBean);
                }
            }
            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
