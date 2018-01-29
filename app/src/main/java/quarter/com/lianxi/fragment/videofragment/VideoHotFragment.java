package quarter.com.lianxi.fragment.videofragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
import quarter.com.lianxi.activity.VideoHotsDetailsActivity;
import quarter.com.lianxi.adapter.VideoHotsAdapter;
import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.presenter.HotVideoPresenter;
import quarter.com.lianxi.util.MySharedPreferences;
import quarter.com.lianxi.util.SpacesItemDecoration;
import quarter.com.lianxi.view.IHotVideoView;

/**
 * 热门视频
 */
public class VideoHotFragment extends Fragment implements IHotVideoView {


    @BindView(R.id.video_hots_xrv)
    XRecyclerView videoHotsXrv;
   // private String cover;
    Unbinder unbinder;
   // private int page=1;
    private boolean falg=true;
    private List<HotVideoBean.DataBean> bigList = new ArrayList<>();
    private VideoHotsAdapter videoHotsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_hot, container, false);
        HotVideoPresenter hotVideoPresenter = new HotVideoPresenter(this);
        hotVideoPresenter.getHotVideo();
        unbinder = ButterKnife.bind(this, view);

        StaggeredGridLayoutManager manager= new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        //防止图片动
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        videoHotsXrv.setLayoutManager(manager);
        return view;
    }


    @Override
    public String getToken() {
        String token = MySharedPreferences.getString("token", 0 + "");
        return token;
    }

    @Override
    public void setHotVideoBean(HotVideoBean hotVideoBean) {
        String msg = hotVideoBean.getMsg();
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        final List<HotVideoBean.DataBean> data = hotVideoBean.getData();
        bigList.addAll(data);
        if (videoHotsAdapter==null){
            videoHotsAdapter = new VideoHotsAdapter(getActivity(),bigList);
            videoHotsXrv.setAdapter(videoHotsAdapter);
        }else{
            videoHotsAdapter.notifyDataSetChanged();
        }

        if (falg){
            //设置瀑布流的间距
            int spacingInPixels = 8;
            videoHotsXrv.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
            falg=false;
        }

        videoHotsXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                bigList.clear();
                videoHotsAdapter.isno(true,data);
                videoHotsXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {

                videoHotsAdapter.isno(false,data);
                videoHotsXrv.loadMoreComplete();
            }
        });


        videoHotsAdapter.VideoHotsListener(new VideoHotsAdapter.VideoHotsListener() {
            @Override
            public void getlistener(int po) {
                Intent intent = new Intent(getActivity(), VideoHotsDetailsActivity.class);
                String videoUrl = bigList.get(po-1).getVideoUrl().replace("https://www.zhaoapi.cn","http://120.27.23.105");
                intent.putExtra("path",videoUrl);
                intent.putExtra("cover",bigList.get(po).getCover());
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
