package quarter.com.lianxi.Api;

import java.util.Map;

import io.reactivex.Observable;
import quarter.com.lianxi.bean.CrossBean;
import quarter.com.lianxi.bean.ForgetBean;
import quarter.com.lianxi.bean.HomeBean;
import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.bean.LoginBean;
import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.bean.PublishBean;
import quarter.com.lianxi.bean.RegBean;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22.
 */

public interface ApiService {
    //首页的接口
    @POST(Api.HOME)
    Observable<HomeBean> gethome();
    //登录接口
    @POST(Api.LOGIN)
    Observable<LoginBean> login(@QueryMap Map<String, String> map);
    //注册接口
    @POST(Api.REG)
    Observable<RegBean> reg(@QueryMap Map<String, String> map);//QueryMap是请求的参数体
    //忘记密码
    @POST(Api.FORGET)
    Observable<ForgetBean> forget(@QueryMap Map<String,String> map);
    //段子
    @POST(Api.CROSS)
    Observable<CrossBean> cross(@QueryMap Map<String,String> map);
    //发布段子
    @POST(Api.FBCROSS)
    Observable<PublishBean> publish(@QueryMap Map<String,String> map);
    //热门视频
    @POST(Api.HOTVIDEO)
    Observable<HotVideoBean> hotvideo(@QueryMap Map<String,String> map);
    //附近的视频
    @POST(Api.NEARBYVIDEO)
    Observable<NearbyVideoBean> nearvideo(@QueryMap Map<String,String> map);


}
