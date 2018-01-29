package quarter.com.lianxi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.R;
//设置登录方式页面
public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.imageView, R.id.other_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                finish();
                break;
            case R.id.other_login:
                Intent intent =new Intent(SetActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
