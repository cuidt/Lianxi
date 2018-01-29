package quarter.com.lianxi.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22
 */
//抽象类
public abstract class BaseActivity<V extends IBaseView,P extends BasePresent<V>> extends AppCompatActivity {
    protected P presenter;
    //抽象方法
    public  abstract P createPresenter();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
         //获取P层实例
         presenter = createPresenter();
         //绑定view
         presenter.addachView((V) this);


    }

    //调用p层的解绑方法 防止内存泄露
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}
