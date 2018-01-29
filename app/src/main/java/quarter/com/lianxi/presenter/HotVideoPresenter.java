package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.model.HotVideoModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.IHotVideoView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/25.
 */

public class HotVideoPresenter {

    IHotVideoView iHotVideoView;
    HotVideoModel hotVideoModel;

    public HotVideoPresenter(IHotVideoView iHotVideoView) {
        this.iHotVideoView = iHotVideoView;
        hotVideoModel = new HotVideoModel();
    }

    public void getHotVideo() {
        String token = iHotVideoView.getToken();
        hotVideoModel.getHotvideo(token, new OnNetLisenter<HotVideoBean>() {
            @Override
            public void onSuccess(HotVideoBean hotVideoBean) {
                if (hotVideoBean.getCode().equals("0")) {
                    iHotVideoView.setHotVideoBean(hotVideoBean);
                }
            }

            @Override
            public void onDefault(Throwable throwable) {
                    throwable.printStackTrace();
            }
        });
    }
}
