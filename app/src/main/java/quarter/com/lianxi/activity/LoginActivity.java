package quarter.com.lianxi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.MainActivity;
import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.LoginBean;
import quarter.com.lianxi.presenter.LoginPresenter;
import quarter.com.lianxi.util.MySharedPreferences;
import quarter.com.lianxi.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.login_num)
    EditText loginNum;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        presenter.login();

    }

    @OnClick({R.id.exit, R.id.user_reg, R.id.login, R.id.wjmm, R.id.ykdl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.exit:
                finish();
                break;
            case R.id.user_reg:
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                String mobile = loginNum.getText().toString().trim();
                String password = loginPwd.getText().toString().trim();
                //判断输入的内容是否为phone
                boolean b = isPhoneNumber(mobile);
                if (mobile.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "用户名/密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!b) {
                    Toast.makeText(LoginActivity.this, "手机号不合法", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(LoginActivity.this, "密码不能少于六位数", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.login();
                }
                break;
            case R.id.wjmm:
                Intent intent2 = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent2);
                break;
            case R.id.ykdl:

                break;
        }
    }

    private boolean isPhoneNumber(String phoneStr) {
        //定义电话格式的正则表达式
        String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        //设定查看模式
        Pattern p = Pattern.compile(regex);
        //判断Str是否匹配，返回匹配结果
        Matcher m = p.matcher(phoneStr);
        return m.find();
    }

    @Override
    public String getMobile() {
        return loginNum.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return loginPwd.getText().toString().trim();
    }

    @Override
    public void setLoginBean(LoginBean bean) {
        //存入头像地址
        String icon = bean.getData().getIcon();
        MySharedPreferences.putString("icon",icon);
        //存入用户id
        int uid = bean.getData().getUid();
        MySharedPreferences.putInt("uid", uid);
        //存入用户名
        String username = bean.getData().getUsername();
        MySharedPreferences.putString("username", username);
        //存入token值
        String token = bean.getData().getToken();
        MySharedPreferences.putString("token",token);
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, uid + "", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("item", 5);
        intent.putExtra("uid", uid);
        startActivity(intent);
    }
}
