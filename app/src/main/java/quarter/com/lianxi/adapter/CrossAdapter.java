package quarter.com.lianxi.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import quarter.com.lianxi.R;
import quarter.com.lianxi.bean.CrossBean;

/**
 * 作者： 崔冬涛
 * 时间： 2018/1/24.
 */
public class CrossAdapter extends XRecyclerView.Adapter<CrossAdapter.ViewHolder> {
    Context context;
    List<CrossBean.DataBean> list;
    Map<Integer, Boolean> map = new HashMap();
    private ImgXRcyclerAdapter adapter;

    public CrossAdapter(Context context, List<CrossBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cross_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.setIsRecyclable(false);//不复用
        Glide.with(context).load(list.get(position).getUser().getIcon()).into(holder.iv_myImg);

        if (map.get(position) == null) {
            map.put(position, false);
        }

        holder.tv_content.setText(list.get(position).getContent());
        holder.tv_time.setText(list.get(position).getCreateTime());
        holder.tv_name.setText(list.get(position).getUser().getNickname());
        String imgUrls = (String) list.get(position).getImgUrls();
        if (imgUrls != null) {
            String[] split = imgUrls.split("\\|");
            if (split.length == 1) {
                adapter = new ImgXRcyclerAdapter(context, split);
                GridLayoutManager manager = new GridLayoutManager(context, 1);
                holder.item_xRecyclerView.setLayoutManager(manager);
                holder.item_xRecyclerView.setAdapter(adapter);
            } else if (split.length == 2) {
                adapter = new ImgXRcyclerAdapter(context, split);
                GridLayoutManager manager = new GridLayoutManager(context, 2);
                holder.item_xRecyclerView.setLayoutManager(manager);
                holder.item_xRecyclerView.setAdapter(adapter);
            } else {
                adapter = new ImgXRcyclerAdapter(context, split);
                GridLayoutManager manager = new GridLayoutManager(context, 3);
                holder.item_xRecyclerView.setLayoutManager(manager);
                holder.item_xRecyclerView.setAdapter(adapter);
            }
        }


        holder.iv_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (map.get(position) == false) {
                    holder.layout_1.setVisibility(View.VISIBLE);
                    holder.layout_2.setVisibility(View.VISIBLE);
                    holder.layout_3.setVisibility(View.VISIBLE);

                    holder.iv_open.setImageResource(R.mipmap.jian);
                    float translationX = holder.layout_1.getTranslationX();
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.layout_1, "translationX", translationX, -100f);

                    float translationX1 = holder.layout_2.getTranslationX();
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(holder.layout_2, "translationX", translationX1, -200f);

                    float translationX2 = holder.layout_3.getTranslationX();
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(holder.layout_3, "translationX", translationX2, -300f);
                    objectAnimator.setDuration(500);
                    objectAnimator1.setDuration(500);
                    objectAnimator2.setDuration(500);
                    objectAnimator.start();
                    objectAnimator1.start();
                    objectAnimator2.start();
                    map.put(position, true);
                } else if (map.get(position) == true) {
                    float translationX = holder.layout_1.getTranslationX();
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.layout_1, "translationX", translationX, 0f);

                    float translationX1 = holder.layout_2.getTranslationX();
                    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(holder.layout_2, "translationX", translationX1, 0f);

                    float translationX2 = holder.layout_3.getTranslationX();
                    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(holder.layout_3, "translationX", translationX2, 0f);

                    objectAnimator.setDuration(500);
                    objectAnimator1.setDuration(500);
                    objectAnimator2.setDuration(500);
                    objectAnimator.start();
                    objectAnimator1.start();
                    objectAnimator2.start();
                    objectAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            holder.layout_1.setVisibility(View.INVISIBLE);
                            holder.layout_2.setVisibility(View.INVISIBLE);
                            holder.layout_3.setVisibility(View.INVISIBLE);
                            holder.iv_open.setImageResource(R.mipmap.jia);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                    map.put(position, false);

                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "水波纹~", Toast.LENGTH_SHORT).show();
            }
        });

        //关注
        holder.iv_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.iv_guanzhu.setImageResource(R.mipmap.xin22);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends XRecyclerView.ViewHolder {

        public ImageView iv_myImg;
        public TextView tv_name;
        public TextView tv_time;
        public TextView tv_content;
        public LinearLayout layout_1;
        public LinearLayout layout_2;
        public LinearLayout layout_3;
        public ImageView iv_open;
        public XRecyclerView item_xRecyclerView;
        public ImageView iv_guanzhu;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_myImg = itemView.findViewById(R.id.iv_myImg);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_content = itemView.findViewById(R.id.tv_content);

            iv_open = itemView.findViewById(R.id.iv_open);

            layout_1 = itemView.findViewById(R.id.layout_1);
            layout_2 = itemView.findViewById(R.id.layout_2);
            layout_3 = itemView.findViewById(R.id.layout_3);

            //获取图片的XRcyclerView
            item_xRecyclerView = itemView.findViewById(R.id.item_xRecyclerView);

            //关注
            iv_guanzhu = itemView.findViewById(R.id.iv_guanzhu);
        }
    }

}
