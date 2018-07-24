package com.bsh.dt.plccustomize.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.model.LayoutTemplate;

import java.util.ArrayList;

/**
 * Created by XuTe on 2018/7/5.
 */

public class TemplateAdapter extends RecyclerView.Adapter<TemplateAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LayoutTemplate> mData;
    private OnItemClickListener onItemClickListener;

    public TemplateAdapter(Context context, ArrayList<LayoutTemplate> data) {
        this.context = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_template, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        LayoutTemplate template = mData.get(position);
        if (template.isSelected()) {
            holder.ivTemplate.setImageResource(template.getImgSelectedResource());
        } else {
            holder.ivTemplate.setImageResource(template.getImgNotSelectedResource());
        }
        holder.ivTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivTemplate;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTemplate = itemView.findViewById(R.id.iv_template);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(int position);
    }
}
