package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.CrossBean;
import quarter.com.lianxi.model.CrossModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.ICrossView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/24.
 */

public class CrossPresenter {

    ICrossView iCrossView;
    CrossModel crossModel;

    public CrossPresenter(ICrossView iCrossView) {
        this.iCrossView = iCrossView;
        crossModel = new CrossModel();
    }

    public void getCross() {
        String token = iCrossView.getToken();
        crossModel.getCross(token, new OnNetLisenter<CrossBean>() {
            @Override
            public void onSuccess(CrossBean crossBean) {
                if (crossBean.getCode().equals("0")) {
                    iCrossView.setCroossBean(crossBean);
                }
            }

            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
