package quarter.com.lianxi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.PublishBean;
import quarter.com.lianxi.presenter.PublishPresenter;
import quarter.com.lianxi.util.MySharedPreferences;
import quarter.com.lianxi.view.IPublishView;

public class PublishActivity extends AppCompatActivity implements IPublishView {

    @BindView(R.id.send_msg)
    EditText sendMsg;
    private PublishPresenter publishPresenter;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
        //沉浸式
        ImmersionBar.with(this)
                .statusBarColor(R.color.shenlan)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看
                .init();
        publishPresenter = new PublishPresenter(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }

    @OnClick({R.id.fb_qx, R.id.fb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fb_qx:
                finish();
                break;
            case R.id.fb:
                msg = sendMsg.getText().toString().trim();
                if(msg.isEmpty()){
                    Toast.makeText(this, "请输入要发表的内容！", Toast.LENGTH_SHORT).show();
                    break;
                }else {
                    publishPresenter.getPublish();
                }
                    break;
        }
    }


    @Override
    public String getToken() {
        String token = MySharedPreferences.getString("token", "0");
        return token;
    }

    @Override
    public String getcontent() {
        return msg;
    }

    @Override
    public String getUid() {
        int uid = MySharedPreferences.getInt("uid", 0);
        return uid + "";
    }

    @Override
    public void setPublishBean(PublishBean publishBean) {

        String msg = publishBean.getMsg();
        Toast.makeText(this, "msg", Toast.LENGTH_SHORT).show();

    }
}
