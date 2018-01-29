package quarter.com.lianxi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.R;

//创做activity
public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);
        //沉浸式
        ImmersionBar.with(this)
                .statusBarColor(R.color.shenlan)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看
                .init();

    }


    @OnClick({R.id.shipin, R.id.duanzi,R.id.cz_qx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cz_qx:
                finish();
                break;
            //点击发表视频
            case R.id.shipin:
                Intent intent1 = new Intent(CreateActivity.this, ReleasedVideoActivity.class);
                startActivity(intent1);
                break;
            //点击发表段子
            case R.id.duanzi:
                Intent intent = new Intent(CreateActivity.this, PublishActivity.class);
                startActivity(intent);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }

}
