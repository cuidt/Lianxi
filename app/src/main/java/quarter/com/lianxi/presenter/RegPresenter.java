package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.RegBean;
import quarter.com.lianxi.model.IRegModel;
import quarter.com.lianxi.model.RegModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.IRegView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */

public class RegPresenter {
    private IRegView view;
    private final IRegModel model;

    public RegPresenter(IRegView view) {
        model = new RegModel();
        this.view = view;
    }
    public void reg() {
        String mobile = view.getMobile();
        String password = view.getPassword();
        model.reg(mobile, password, new OnNetLisenter<RegBean>() {
            @Override
            public void onSuccess(RegBean registBean) {
                if (registBean.getCode().equals("0")) {
                    view.setReg(registBean);
                }
            }
            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }
}
