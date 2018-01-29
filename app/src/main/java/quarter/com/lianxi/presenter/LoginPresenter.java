package quarter.com.lianxi.presenter;

import quarter.com.lianxi.bean.LoginBean;
import quarter.com.lianxi.model.ILoginModel;
import quarter.com.lianxi.model.LoginModel;
import quarter.com.lianxi.net.OnNetLisenter;
import quarter.com.lianxi.view.ILoginView;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */

public class LoginPresenter {
    private ILoginView view;
    private final ILoginModel model;

    public LoginPresenter(ILoginView view) {
        model = new LoginModel();
        this.view = view;
    }
    public void login(){
        String mobile = view.getMobile();
        String password = view.getPassword();
        model.login(mobile, password, new OnNetLisenter<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                if ("0".equals(loginBean.getCode())){
                    view.setLoginBean(loginBean);
                }
            }

            @Override
            public void onDefault(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
