package quarter.com.lianxi.view;

import quarter.com.lianxi.bean.RegBean;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/23.
 */

public interface IRegView {
    String getMobile();

    String getPassword();

    void setReg(RegBean bean);
}
