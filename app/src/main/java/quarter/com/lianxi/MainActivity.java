package quarter.com.lianxi;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.activity.CreateActivity;
import quarter.com.lianxi.fragment.CrossFragment;
import quarter.com.lianxi.fragment.RecommendFragment;
import quarter.com.lianxi.fragment.VideoFragment;
import quarter.com.lianxi.util.MySharedPreferences;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_bottom_tuijian)
    TextView mainBottomTuijian;
    @BindView(R.id.main_bottom_duanzi)
    TextView mainBottomDuanzi;
    @BindView(R.id.main_bottom_shipin)
    TextView mainBottomShipin;
    @BindView(R.id.main_title_sdv)
    SimpleDraweeView mainTitleSdv;
    @BindView(R.id.main_title_tv)
    TextView mainTitleTv;
    @BindView(R.id.main_activity)
    DrawerLayout mainActivity;
    @BindView(R.id.right)
    LinearLayout right;
    @BindView(R.id.left)
    FrameLayout left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this)
                .statusBarColor(R.color.shenlan)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看
                .init();
        ButterKnife.bind(this);


        setFragment(new RecommendFragment());
        //获取用户头像
        String icon = MySharedPreferences.getString("icon", 0 + "");
        mainTitleSdv.setImageURI(icon);
        //侧滑挤进去视图
        mainActivity.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left
                //   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                right.layout(left.getRight(), 0, left.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }

    private void setBottomClick(int resId, TextView tv) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, drawable, null, null);
    }

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, fragment).commit();
    }

    @OnClick({R.id.main_bottom_tuijian, R.id.main_bottom_duanzi, R.id.main_bottom_shipin, R.id.main_title_sdv,R.id.main_title_creation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_bottom_tuijian:
                RecommendFragment recommendFragment = new RecommendFragment();
                setFragment(recommendFragment);
                setBottomClick(R.mipmap.xza, (TextView) findViewById(R.id.main_bottom_tuijian));
                setBottomClick(R.mipmap.wxzb, (TextView) findViewById(R.id.main_bottom_duanzi));
                setBottomClick(R.mipmap.wxzc, (TextView) findViewById(R.id.main_bottom_shipin));
                mainBottomTuijian.setTextColor(this.getResources().getColor(R.color.blue));
                mainBottomDuanzi.setTextColor(this.getResources().getColor(R.color.hui));
                mainBottomShipin.setTextColor(this.getResources().getColor(R.color.hui));
                break;
            case R.id.main_bottom_duanzi:
                mainTitleTv.setText("段子");
                CrossFragment crossFragment = new CrossFragment();
                setFragment(crossFragment);
                setBottomClick(R.mipmap.wxza, (TextView) findViewById(R.id.main_bottom_tuijian));
                setBottomClick(R.mipmap.xzb, (TextView) findViewById(R.id.main_bottom_duanzi));
                setBottomClick(R.mipmap.wxzc, (TextView) findViewById(R.id.main_bottom_shipin));
                mainBottomTuijian.setTextColor(this.getResources().getColor(R.color.hui));
                mainBottomDuanzi.setTextColor(this.getResources().getColor(R.color.blue));
                mainBottomShipin.setTextColor(this.getResources().getColor(R.color.hui));
                break;
            case R.id.main_bottom_shipin:
                mainTitleTv.setText("视频");
                VideoFragment videoFragment = new VideoFragment();
                setFragment(videoFragment);
                setBottomClick(R.mipmap.wxza, (TextView) findViewById(R.id.main_bottom_tuijian));
                setBottomClick(R.mipmap.wxzb, (TextView) findViewById(R.id.main_bottom_duanzi));
                setBottomClick(R.mipmap.xzc, (TextView) findViewById(R.id.main_bottom_shipin));
                mainBottomTuijian.setTextColor(this.getResources().getColor(R.color.hui));
                mainBottomDuanzi.setTextColor(this.getResources().getColor(R.color.hui));
                mainBottomShipin.setTextColor(this.getResources().getColor(R.color.blue));
                break;
            case R.id.main_title_sdv:
                mainActivity.openDrawer(Gravity.LEFT);
                break;
            case R.id.main_title_creation:
                Intent intent =new Intent(MainActivity.this, CreateActivity.class);
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
