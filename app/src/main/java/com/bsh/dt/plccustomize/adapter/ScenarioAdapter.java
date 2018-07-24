package com.bsh.dt.plccustomize.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.model.Data;

import java.util.ArrayList;

/**
 * Created by XuTe on 2018/7/3.
 */

public class ScenarioAdapter extends RecyclerView.Adapter<ScenarioAdapter.ViewHolder> {

    private ArrayList<Data> data;
    private Context context;

    private OnItemClickListener onItemClickListener;

    public ScenarioAdapter(ArrayList<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ScenarioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_scenario, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Data scenarioData = data.get(position);
        holder.ivScenario.setImageResource(scenarioData.getPicture());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
        if (scenarioData.isSelected()) {
            holder.ivScenario.setBackgroundResource(R.drawable.frame_selected);
        } else {
            holder.ivScenario.setBackgroundResource(R.drawable.frame_not_selected);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivScenario;

        public ViewHolder(View itemView) {
            super(itemView);
            ivScenario = itemView.findViewById(R.id.iv_scenario);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(int position);
    }
}
