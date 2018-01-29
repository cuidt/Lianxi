package quarter.com.lianxi.net;


import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import quarter.com.lianxi.Api.ApiService;
import quarter.com.lianxi.bean.CrossBean;
import quarter.com.lianxi.bean.ForgetBean;
import quarter.com.lianxi.bean.HomeBean;
import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.bean.LoginBean;
import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.bean.PublishBean;
import quarter.com.lianxi.bean.RegBean;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22.
 */

//写网络请求的方法
public class HttpMethods {

    private final ApiService service;

    //单例模式
    private HttpMethods() {
        service = HttpResService.getInstnce().getService();
    }

    private static HttpMethods instnce = null;

    public static HttpMethods getInstnce() {
        if (instnce == null) {
            synchronized (HttpMethods.class) {
                if (instnce == null) {
                    instnce = new HttpMethods();
                }
            }

        }
        return instnce;
    }


    private <T> void toConsumer(Observable<T> observable, Consumer<T> consumer, Consumer<Throwable> throwable) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer, throwable);
    }
    //首页广告
    public void getHome(Consumer<HomeBean> consumer, Consumer<Throwable> throwable) {

        Observable<HomeBean> observable = service.gethome();
        toConsumer(observable, consumer, throwable);

    }
    //登录接口
    public void login(Map<String, String> map, Consumer<LoginBean> consumer, Consumer<Throwable> throwable) {

        Observable<LoginBean> observable = service.login(map);
        toConsumer(observable, consumer, throwable);

    }

    //注册接口
    public void reg(Map<String, String> map, Consumer<RegBean> consumer, Consumer<Throwable> throwable) {

        Observable<RegBean> observable = service.reg(map);
        toConsumer(observable, consumer, throwable);

    }

    //修改密码
    public void forget(Map<String, String> map, Consumer<ForgetBean> consumer, Consumer<Throwable> throwable) {

        Observable<ForgetBean> observable = service.forget(map);
        toConsumer(observable, consumer, throwable);

    }

    //段子接口
    public void cross(Map<String, String> map, Consumer<CrossBean> consumer, Consumer<Throwable> throwable) {

        Observable<CrossBean> observable = service.cross(map);
        toConsumer(observable, consumer, throwable);
    }
    //发布段子
    public void publish (Map<String, String> map, Consumer<PublishBean> consumer, Consumer<Throwable> throwable) {

        Observable<PublishBean> observable = service.publish(map);
        toConsumer(observable, consumer, throwable);
    }
    //热门视频
    public void hotvideo (Map<String, String> map, Consumer<HotVideoBean> consumer, Consumer<Throwable> throwable) {

        Observable<HotVideoBean> observable = service.hotvideo(map);
        toConsumer(observable, consumer, throwable);
    }

    //附近视频
    public void nearbyvideo (Map<String, String> map, Consumer<NearbyVideoBean> consumer, Consumer<Throwable> throwable) {

        Observable<NearbyVideoBean> observable = service.nearvideo(map);
        toConsumer(observable, consumer, throwable);
    }


        /*
        //上传头像
        public void loadHeadPortrait(int uid, MultipartBody.Part file, Consumer<HandPortraitBean> consumer, Consumer<Throwable> throwable) {
            Observable<HandPortraitBean> observable = service.loadHandPortrait(uid, file);
            toConsumer(observable, consumer, throwable);
        }

        //修改购物车
        public void update(Map<String, String> map, Consumer<UpDataCardBean> consumer, Consumer<Throwable> throwable) {
            Observable<UpDataCardBean> observable = service.update(map);
            toConsumer(observable, consumer, throwable);
        }

        //关键词搜索商品
        public void search(Map<String,String> map , Consumer<SearchBean> consumer,Consumer<Throwable> throwable){
            Observable<SearchBean> observable =service.search(map);
            toConsumer(observable, consumer, throwable);
        }
    */

}
