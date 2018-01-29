package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.ForgetBean;
import quarter.com.lianxi.model.ForgetModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.IForgetView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/29.
 */

public class ForgetPresenter {

    IForgetView iForgetView;
    ForgetModel forgetModel;

    public ForgetPresenter(IForgetView iForgetView) {
        this.iForgetView = iForgetView;
        forgetModel = new ForgetModel();
    }

    public void getForget() {
        String uid = iForgetView.getUid();
        String oldPwd = iForgetView.getOldPwd();
        String newPwd = iForgetView.getNewPwd();
        forgetModel.getPwd(uid, oldPwd, newPwd, new OnNetLisenter<ForgetBean>() {
            @Override
            public void onSuccess(ForgetBean forgetBean) {
                if (forgetBean.getCode().equals("0")) {
                    iForgetView.setForgerBean(forgetBean);
                }
            }

            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
