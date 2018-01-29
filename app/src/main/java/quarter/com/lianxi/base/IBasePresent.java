package quarter.com.lianxi.base;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22.
 */

public interface IBasePresent<V extends IBaseView>  {

    void addachView(V baseView);

    void detachView();

}
