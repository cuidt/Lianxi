package quarter.com.lianxi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.NearbyVideoBean;
import quarter.com.lianxi.util.DividerUtils;
import quarter.com.lianxi.util.ScreenUtils;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/27.
 */

public class VideoNearbyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private Context context;
    private List<NearbyVideoBean.DataBean> list;
    public VideoNearbyAdapter(Context context, List<NearbyVideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void isno(boolean flag, List<NearbyVideoBean.DataBean> bean) {
        if (flag) {
            for (NearbyVideoBean.DataBean datas : bean) {
                list.add(0, datas);
            }
        } else {
            list.addAll(bean);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_nearby_item, parent,false);
      /*  final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoNearbyListener.getlistener(list.get(po));
            }
        });*/
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            Glide.with(context)
                    .asBitmap()
                    .load(list.get(position).getCover())
                    .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            int imgwidth = resource.getWidth();
                            int imgheight = resource.getHeight();
                            int width = ScreenUtils.getScreenWidth(context) / 2;
                            double div = DividerUtils.div(width, imgwidth, 2);
                            int height = (int) (imgheight * (div));
                            ViewGroup.LayoutParams para = ((ViewHolder) holder).videonearbyIcon.getLayoutParams();
                            para.width = width;
                            para.height = height;
                            ((ViewHolder) holder).videonearbyIcon.setImageBitmap(resource);
                        }
                    });

        }
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.videonearbyIcon.setImageURI(list.get(position).getCover());
        viewHolder.videonearbyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoNearbyListener.getlistener(list.get(position).getVideoUrl());
            }
        });

    }

    public VideoNearbyListener videoNearbyListener;

    public void VideoNearbyListener(VideoNearbyListener videoNearbyListener) {
        this.videoNearbyListener = videoNearbyListener;
    }

    public interface VideoNearbyListener {
        void getlistener(String po);
    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_nearby_icon)
        SimpleDraweeView videonearbyIcon;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
