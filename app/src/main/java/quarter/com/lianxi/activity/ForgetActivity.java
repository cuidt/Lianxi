package quarter.com.lianxi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.ForgetBean;
import quarter.com.lianxi.util.MySharedPreferences;
import quarter.com.lianxi.view.IForgetView;

public class ForgetActivity extends AppCompatActivity implements IForgetView {

    @BindView(R.id.sr_phone)
    EditText srPhone;
    @BindView(R.id.sr_yzm)
    EditText srYzm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.exit, R.id.yyzh, R.id.hq_yzm, R.id.xyb, R.id.ykdl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.exit:
                finish();
                break;
            //旧密码
            case R.id.yyzh:

                break;
            //新密码
            case R.id.hq_yzm:

                break;
            //修改完成确定
            case R.id.xyb:

                break;
            //游客登录
            case R.id.ykdl:
        
                break;
        }
    }

    @Override
    public String getUid() {
        int uid = MySharedPreferences.getInt("uid", 0);
        return uid + "";
    }

    @Override
    public String getOldPwd() {

        return null;
    }

    @Override
    public String getNewPwd() {
        return null;
    }

    @Override
    public void setForgerBean(ForgetBean forgerBean) {


    }
}
