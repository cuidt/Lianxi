package quarter.com.lianxi.view;

import quarter.com.lianxi.bean.ForgetBean;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/29.
 */

public interface IForgetView {

    String getUid();

    String getOldPwd();

    String getNewPwd();

    void setForgerBean(ForgetBean forgerBean);

}
