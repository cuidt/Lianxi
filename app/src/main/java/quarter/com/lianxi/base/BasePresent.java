package quarter.com.lianxi.base;

import java.lang.ref.WeakReference;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/22
 */

public class BasePresent<V extends IBaseView> implements IBasePresent<V> {
    //WeakReference弱引用
    protected WeakReference<V> weakView;

    //邦定view
    @Override
    public void addachView(V baseView) {
        weakView =new WeakReference<V>(baseView);
    }
    //解绑   当一个对象不再被其他对象引用的时候，是会被GC回收的，很显然及时a=null，
    // 那么A对象也是不可能被回收的，因为B依然依赖与A，在这个时候，造成了内存泄漏！
    @Override
    public void detachView() {
        if(weakView !=null){
            weakView.clear();
        }
    }

}
