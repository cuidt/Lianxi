package quarter.com.lianxi.net;
/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22.
 */
public interface OnNetLisenter<T> {

    void onSuccess(T t);
    void onDefault(Throwable throwable);

}
