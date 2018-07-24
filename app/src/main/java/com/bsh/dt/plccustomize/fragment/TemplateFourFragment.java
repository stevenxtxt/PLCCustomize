package com.bsh.dt.plccustomize.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.base.BaseFragment;
import com.bsh.dt.plccustomize.constant.Constant;
import com.bsh.dt.plccustomize.model.Data;
import com.bsh.dt.plccustomize.model.Program;
import com.bsh.dt.plccustomize.widget.LeanTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by XuTe on 2018/7/6.
 */

public class TemplateFourFragment extends BaseFragment {
    @BindView(R.id.iv_program1) ImageView ivProgram1;
    @BindView(R.id.ltv_program1) LeanTextView ltvProgram1;
    @BindView(R.id.rl_program1) RelativeLayout rlProgram1;
    @BindView(R.id.iv_program2) ImageView ivProgram2;
    @BindView(R.id.ltv_program2) LeanTextView ltvProgram2;
    @BindView(R.id.rl_program2) RelativeLayout rlProgram2;
    @BindView(R.id.iv_program5) ImageView ivProgram5;
    @BindView(R.id.ltv_program5) LeanTextView ltvProgram5;
    @BindView(R.id.rl_program5) RelativeLayout rlProgram5;
    @BindView(R.id.iv_program4) ImageView ivProgram4;
    @BindView(R.id.ltv_program4) LeanTextView ltvProgram4;
    @BindView(R.id.rl_program4) RelativeLayout rlProgram4;
    @BindView(R.id.iv_program3) ImageView ivProgram3;
    @BindView(R.id.ltv_program3) LeanTextView ltvProgram3;
    @BindView(R.id.rl_program3) RelativeLayout rlProgram3;

    private ArrayList<Program> programs;
    private int size;

    @Override
    public int getLayoutId() {
        int id = 0;
        if (size == Constant.LARGE) {
            id = R.layout.layout_five_items_three;

        } else if (size == Constant.SMALL) {
            id = R.layout.layout_five_items_three_small;
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
        ltvProgram1.setText(program1.getName());
        ivProgram1.setImageResource(program1.getPictureHorizontal());

        Program program2 = programs.get(1);
        ltvProgram2.setText(program2.getName());
        ivProgram2.setImageResource(program2.getPictureHorizontal());

        Program program3 = programs.get(2);
        ltvProgram3.setText(program3.getName());
        ivProgram3.setImageResource(program3.getPictureHorizontal());

        Program program4 = programs.get(3);
        ltvProgram4.setText(program4.getName());
        ivProgram4.setImageResource(program4.getPictureHorizontal());

        Program program5 = programs.get(4);
        ltvProgram5.setText(program5.getName());
        ivProgram5.setImageResource(program5.getPictureHorizontal());
        return view;
    }

}
