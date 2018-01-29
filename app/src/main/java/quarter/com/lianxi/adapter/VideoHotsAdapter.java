package quarter.com.lianxi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.HotVideoBean;
import quarter.com.lianxi.util.DividerUtils;
import quarter.com.lianxi.util.ScreenUtils;

public class VideoHotsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<HotVideoBean.DataBean> list;

    public VideoHotsAdapter(Context context, List<HotVideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void isno(boolean flag, List<HotVideoBean.DataBean> bean) {
        if (flag) {
            for (HotVideoBean.DataBean datas : bean) {
                list.add(0, datas);
            }
        } else {
            list.addAll(bean);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = View.inflate(context, R.layout.video_hots_item, null);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoHotsListener.getlistener(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    /* @Override
     public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
         if (holder instanceof ViewHolder) {
             Glide.with(context)
                     .asBitmap()
                     .load(list.get(position).getCover())
                     .into(((ViewHolder) holder).videoHotsIcon);

         }
     }
 */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
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
            ViewGroup.LayoutParams para = ((ViewHolder) holder).videoHotsIcon.getLayoutParams();
            para.width = width;
            para.height = height;
            ((ViewHolder) holder).videoHotsIcon.setImageBitmap(resource);
        }
    });

        }
    }

    public VideoHotsListener videoHotsListener;

    public void VideoHotsListener(VideoHotsListener videoHotsListener) {
        this.videoHotsListener = videoHotsListener;
    }

    public interface VideoHotsListener {
        void getlistener(int po);
    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_hots_icon)
        ImageView videoHotsIcon;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}