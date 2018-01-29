package quarter.com.lianxi.view;


import quarter.com.lianxi.bean.LoginBean;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */
public interface ILoginView {
    String getMobile();
    String getPassword();
    void setLoginBean(LoginBean bean);
}
