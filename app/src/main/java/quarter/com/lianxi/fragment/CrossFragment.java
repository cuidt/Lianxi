package quarter.com.lianxi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import quarter.com.lianxi.R;
import quarter.com.lianxi.adapter.CrossAdapter;
import quarter.com.lianxi.bean.CrossBean;
import quarter.com.lianxi.presenter.CrossPresenter;
import quarter.com.lianxi.util.MySharedPreferences;
import quarter.com.lianxi.view.ICrossView;

/**
 * 段子页面
 */
public class CrossFragment extends Fragment implements ICrossView {
    private XRecyclerView xRecyclerView;
    private CrossAdapter crossAdapter;
    private LinearLayoutManager layoutManager;
    private int page = 1;
    private List<CrossBean.DataBean> data;
    private CrossPresenter crossPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cross, container, false);
        crossPresenter = new CrossPresenter(this);
        crossPresenter.getCross();
        data = new ArrayList<>();
        xRecyclerView = view.findViewById(R.id.xRecyclerView);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        return view;
    }

    @Override
    public String getToken() {
        String token = MySharedPreferences.getString("token", "0");
        return token;
    }

    @Override
    public void setCroossBean(CrossBean croossBean) {

        String msg = croossBean.getMsg();
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        data.addAll(croossBean.getData());

        //关联适配器
        if (crossAdapter == null) {
            crossAdapter = new CrossAdapter(getActivity(), data);
            xRecyclerView.setAdapter(crossAdapter);
            layoutManager = new LinearLayoutManager(getActivity());
            xRecyclerView.setLayoutManager(layoutManager);
        } else {
            crossAdapter.notifyDataSetChanged();
        }

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //  crossPresenter.duanzi(page+"");
                xRecyclerView.refreshComplete();
                //  ShowToast("刷新成功");
                Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoadMore() {
                page++;
                //  crossPresenter.duanzi(page+"");
                xRecyclerView.loadMoreComplete();
                //ShowToast("加载成功");
                Toast.makeText(getActivity(), "加载成功", Toast.LENGTH_SHORT).show();
                // System.out.println("page------------"+page);
            }
        });
    }
}
