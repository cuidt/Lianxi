package quarter.com.lianxi.net;


import okhttp3.OkHttpClient;
import quarter.com.lianxi.Api.Api;
import quarter.com.lianxi.Api.ApiService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22.
 */

public class HttpResService {
    //synchronized同步锁  线程安全
    private synchronized Retrofit.Builder getBuilder() {

        OkHttpClient.Builder clientBuder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = clientBuder.build();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.client(okHttpClient);
        builder.baseUrl(Api.BASEURL);
        return builder;

    }


    public synchronized ApiService getService() {

        Retrofit retrofit = getBuilder().build();
        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;

    }

    //单例模式
    //私有构造
    private HttpResService() {


    }

    private static HttpResService instnce = null;

    public static HttpResService getInstnce() {
        if (instnce == null) {
            synchronized (HttpResService.class) {
                if (instnce == null) {
                    instnce = new HttpResService();
                }
            }
        }
        return instnce;
    }

}
