package quarter.com.lianxi.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;

import java.io.File;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quarter.com.lianxi.R;
import quarter.com.lianxi.util.MySharedPreferences;

public class ExitActivity extends AppCompatActivity {

    @BindView(R.id.hcdx)
    TextView hcdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_exit);
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarColor(R.color.shenlan)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)  //使用该属性必须指定状态栏的颜色，不然状态栏透明，很难看
                .init();
        DataCleanManager d = new DataCleanManager();
        try {
            String size = d.getTotalCacheSize(this);
            hcdx.setText(size);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }

    @OnClick({R.id.exit, R.id.jcgx, R.id.yjfk, R.id.gy, R.id.qchc, R.id.tcdl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.exit:
                finish();
                break;
            case R.id.jcgx:
                Toast.makeText(this, "亲！已是最新版本了！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yjfk:
                Toast.makeText(this, "有意见保留！谢谢！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gy:
                Toast.makeText(this, "一刻钟就是一刻钟！不懂百度去！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.qchc:
                DataCleanManager d = new DataCleanManager();
                d.clearAllCache(this);
                try {
                    String totalCacheSize = d.getTotalCacheSize(this);
                    hcdx.setText(totalCacheSize);
                    Toast.makeText(this, "亲！已经很干净咯！", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tcdl:
                //点击退出登录的时候
                MySharedPreferences.clear();
                Toast.makeText(this, "退出成功！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class DataCleanManager {

        public String getTotalCacheSize(Context context) throws Exception {
            long cacheSize = getFolderSize(context.getCacheDir());
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                cacheSize += getFolderSize(context.getExternalCacheDir());
            }
            return getFormatSize(cacheSize);
        }


        public void clearAllCache(Context context) {
            deleteDir(context.getCacheDir());
            if (Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)) {
                deleteDir(context.getExternalCacheDir());
            }
        }


        private boolean deleteDir(File dir) {
            if (dir != null && dir.isDirectory()) {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++) {
                    boolean success = deleteDir(new File(dir, children[i]));
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        }

        // 获取文件
        // Context.getExternalFilesDir() --> SDCard/Android/data/你的应用的包名/files/
        // 目录，一般放一些长时间保存的数据
        // Context.getExternalCacheDir() -->
        // SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
        public long getFolderSize(File file) throws Exception {
            long size = 0;
            try {
                File[] fileList = file.listFiles();
                for (int i = 0; i < fileList.length; i++) {
                    // 如果下面还有文件
                    if (fileList[i].isDirectory()) {
                        size = size + getFolderSize(fileList[i]);
                    } else {
                        size = size + fileList[i].length();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return size;
        }

        /**
         * 格式化单位
         *
         * @param size
         * @return
         */
        public String getFormatSize(double size) {
            double kiloByte = size / 1024;
            if (kiloByte < 1) {
                // return size + "Byte";
                return "0K";
            }


            double megaByte = kiloByte / 1024;
            if (megaByte < 1) {
                BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
                return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toPlainString() + "KB";
            }


            double gigaByte = megaByte / 1024;
            if (gigaByte < 1) {
                BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
                return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toPlainString() + "MB";
            }


            double teraBytes = gigaByte / 1024;
            if (teraBytes < 1) {
                BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
                return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                        .toPlainString() + "GB";
            }
            BigDecimal result4 = new BigDecimal(teraBytes);
            return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                    + "TB";
        }
    }
}
