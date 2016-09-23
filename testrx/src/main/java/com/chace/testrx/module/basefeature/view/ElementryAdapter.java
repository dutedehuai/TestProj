package com.chace.testrx.module.basefeature.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chace.testrx.R;
import com.chace.testrx.model.ZBImageInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by chacewang on 16/9/23.
 */
public class ElementryAdapter extends RecyclerView.Adapter {
    private List<ZBImageInfo> mZBImageInfos;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        return new ZBViewHolder(inflate.inflate(R.layout.item_girdrecyle_elementray, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ZBViewHolder zbViewHolder = (ZBViewHolder) holder;
        ZBImageInfo imageInfo = mZBImageInfos.get(position);
        Glide.with(zbViewHolder.itemView.getContext()).load(imageInfo.getImage_url()).into(zbViewHolder.imageview);
        zbViewHolder.descTextView.setText(imageInfo.getDescription());
    }

    @Override
    public int getItemCount() {
        return mZBImageInfos == null ? 0 : mZBImageInfos.size();
    }

    public void setZBImageInfos(List<ZBImageInfo> ZBImageInfos) {
        mZBImageInfos = ZBImageInfos;
        notifyDataSetChanged();
    }

    static class ZBViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        public ImageView imageview;
        @BindView(R.id.descriptText)
        public TextView descTextView;
        public ZBViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
