package quarter.com.lianxi.fragment.videofragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import quarter.com.lianxi.R;
import quarter.com.lianxi.activity.VideoHotsDetailsActivity;
import quarter.com.lianxi.adapter.VideoNearbyAdapter;
import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.presenter.NearbyPresenter;
import quarter.com.lianxi.util.MySharedPreferences;
import quarter.com.lianxi.util.SpacesItemDecoration;
import quarter.com.lianxi.view.INearbyView;

/**
 * 附近的视频
 */
public class VideoNearbyFragment extends Fragment implements INearbyView {

    @BindView(R.id.video_nearby_xrv)
    XRecyclerView videoNearbyXrv;
    Unbinder unbinder;
    private NearbyPresenter nearbyPresenter;
    private boolean falg = true;
    private VideoNearbyAdapter videoNearbyAdapter;
    private List<NearbyVideoBean.DataBean> bigList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_nearby, container, false);
        unbinder = ButterKnife.bind(this, view);
        nearbyPresenter = new NearbyPresenter(this);
        nearbyPresenter.getNearby();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        //防止图片动
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        videoNearbyXrv.setLayoutManager(manager);
        return view;
    }

    @Override
    public String getToken() {
        String token = MySharedPreferences.getString("token", 0 + "");
        return token;
    }

    @Override
    public void setNearbyBean(NearbyVideoBean nearbyBean) {
          String msg = nearbyBean.getMsg();
           Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        //  fj.setText(msg);
        {
        /*String msg = hotVideoBean.getMsg();*/
       Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            final List<NearbyVideoBean.DataBean> data = nearbyBean.getData();
            bigList.addAll(data);
            if (videoNearbyAdapter == null) {
                videoNearbyAdapter = new VideoNearbyAdapter(getActivity(), bigList);
                videoNearbyXrv.setAdapter(videoNearbyAdapter);
            } else {
                videoNearbyAdapter.notifyDataSetChanged();
            }

            if (falg) {
                //设置瀑布流的间距
                int spacingInPixels = 8;
                videoNearbyXrv.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
                falg = false;
            }

            videoNearbyXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    bigList.clear();
                    videoNearbyAdapter.isno(true, data);
                    videoNearbyXrv.refreshComplete();
                }

                @Override
                public void onLoadMore() {

                    videoNearbyAdapter.isno(false, data);
                    videoNearbyXrv.loadMoreComplete();
                }
            });

/*
            videoNearbyAdapter.VideoNearbyListener(new VideoHotsAdapter.VideoHotsListener() {
                @Override
                public void getlistener(int po) {
                    Intent intent = new Intent(getActivity(), VideoHotsDetailsActivity.class);
                    String videoUrl = bigList.get(po-1).getVideoUrl().replace("https://www.zhaoapi.cn","http://120.27.23.105");
                    intent.putExtra("path",videoUrl);
                    intent.putExtra("cover",bigList.get(po).getCover());
                    startActivity(intent);
                }
            });*/
        }

        /*    videoNearbyAdapter.VideoNearbyListener(new VideoNearbyAdapter.VideoNearbyListener() {
                @Override
                public void getlistener(int po) {
                    Intent intent = new Intent(getActivity(), VideoHotsDetailsActivity.class);
                   // String videoUrl = bigList.get(po - 1).getVideoUrl().replace("https://www.zhaoapi.cn", "http://120.27.23.105");
                  //  Log.d("++++++++++++++++",videoUrl);
                    intent.putExtra("path", po);
                   // intent.putExtra("cover", bigList.get(po).getCover());
                    startActivity(intent);
                }
            });*/
        VideoNearbyAdapter videoNearbyAdapter = new VideoNearbyAdapter(getActivity(), nearbyBean.getData());
        videoNearbyXrv.setAdapter(videoNearbyAdapter);
        videoNearbyAdapter.VideoNearbyListener(new VideoNearbyAdapter.VideoNearbyListener() {
            @Override
            public void getlistener(String po) {
                Intent intent = new Intent(getActivity(), VideoHotsDetailsActivity.class);
                intent.putExtra("mv", po);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
