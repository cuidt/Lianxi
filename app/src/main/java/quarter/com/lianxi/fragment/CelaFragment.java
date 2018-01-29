package quarter.com.lianxi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import quarter.com.lianxi.R;
import quarter.com.lianxi.activity.ExitActivity;
import quarter.com.lianxi.activity.SetActivity;
import quarter.com.lianxi.util.MySharedPreferences;

/**
 * A simple {@link Fragment} subclass.
 */
public class CelaFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.user_tx)
    SimpleDraweeView userTx;
    @BindView(R.id.user_name)
    TextView userName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cela, container, false);
        unbinder = ButterKnife.bind(this, view);
        String icon = MySharedPreferences.getString("icon", 0 + "");
        userTx.setImageURI(icon);
        String username = MySharedPreferences.getString("username", 0 + "");
        userName.setText(username);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.login_page, R.id.user_tx, R.id.user_name, R.id.my_guanzhu, R.id.my_shoucang, R.id.my_sousuo, R.id.my_tongzhi, R.id.yejian, R.id.my_zuopin, R.id.my_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_page:
                Intent intent = new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
                break;
            case R.id.user_tx:
                Toast.makeText(getActivity(), "正在开发", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_name:
                break;
            case R.id.my_guanzhu:
                break;
            case R.id.my_shoucang:
                break;
            case R.id.my_sousuo:
                break;
            case R.id.my_tongzhi:
                break;
            case R.id.yejian:
                break;
            case R.id.my_zuopin:
                break;
            case R.id.my_set:
                Intent intent1 =new Intent(getActivity(), ExitActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
