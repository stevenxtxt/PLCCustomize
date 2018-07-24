package com.bsh.dt.plccustomize.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.base.BaseFragment;
import com.bsh.dt.plccustomize.constant.Constant;
import com.bsh.dt.plccustomize.model.Data;
import com.bsh.dt.plccustomize.model.Program;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by XuTe on 2018/7/6.
 */

public class TemplateThreeFragment extends BaseFragment {
    @BindView(R.id.iv_program1) ImageView ivProgram1;
    @BindView(R.id.tv_program1) TextView tvProgram1;
    @BindView(R.id.rl_program1) RelativeLayout rlProgram1;
    @BindView(R.id.iv_program2) ImageView ivProgram2;
    @BindView(R.id.tv_program2) TextView tvProgram2;
    @BindView(R.id.rl_program2) RelativeLayout rlProgram2;
    @BindView(R.id.iv_program3) ImageView ivProgram3;
    @BindView(R.id.tv_program3) TextView tvProgram3;
    @BindView(R.id.rl_program3) RelativeLayout rlProgram3;
    @BindView(R.id.iv_program4) ImageView ivProgram4;
    @BindView(R.id.tv_program4) TextView tvProgram4;
    @BindView(R.id.rl_program4) RelativeLayout rlProgram4;
    @BindView(R.id.iv_program5) ImageView ivProgram5;
    @BindView(R.id.tv_program5) TextView tvProgram5;
    @BindView(R.id.rl_program5) RelativeLayout rlProgram5;

    private ArrayList<Program> programs;
    private int size;

    @Override
    public int getLayoutId() {
        int id = 0;
        if (size == Constant.LARGE) {
            id = R.layout.layout_five_items_four;

        } else if (size == Constant.SMALL) {
            id = R.layout.layout_five_items_four_small;
        }
        return id;
    }

    @Override
    public void handleBundle(Bundle bundle) {
        programs = (ArrayList<Program>) bundle.getSerializable(Constant.DATA_EXTRA);
        size = bundle.getInt(Constant.INT_EXTRA);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Program program1 = programs.get(0);
        tvProgram1.setText(program1.getName());


        Program program2 = programs.get(1);
        tvProgram2.setText(program2.getName());

        Program program3 = programs.get(2);
        tvProgram3.setText(program3.getName());

        Program program4 = programs.get(3);
        tvProgram4.setText(program4.getName());

        Program program5 = programs.get(4);
        tvProgram5.setText(program5.getName());

        return view;
    }

}
