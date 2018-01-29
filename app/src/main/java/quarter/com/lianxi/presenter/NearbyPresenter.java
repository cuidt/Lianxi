package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.model.NearbyModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.IHotVideoView;
import quarter.com.lianxi.view.INearbyView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public class NearbyPresenter {

    INearbyView iNearbyView;
    NearbyModel nearbyModel;

    public NearbyPresenter(INearbyView iNearbyView) {
        this.iNearbyView = iNearbyView;
        nearbyModel = new NearbyModel();
    }

    public void getNearby() {
        String token = iNearbyView.getToken();
        nearbyModel.getNearbyVideo(token, new OnNetLisenter<NearbyVideoBean>() {
            @Override
            public void onSuccess(NearbyVideoBean nearbyVideoBean) {
                if (nearbyVideoBean.getCode().equals("0")) {
                        iNearbyView.setNearbyBean(nearbyVideoBean);
                }
            }
            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
