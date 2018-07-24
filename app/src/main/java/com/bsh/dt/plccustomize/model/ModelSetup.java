package com.bsh.dt.plccustomize.model;

import android.content.Context;

import com.bsh.dt.plccustomize.R;
import com.bsh.dt.plccustomize.constant.Constant;

import java.util.ArrayList;

/**
 * Created by XuTe on 2018/7/5.
 */

public class ModelSetup {
    public static ArrayList<Data> initDataList(Context context) {
        ArrayList<Program> list = new ArrayList<>();
        Program programCotton = new Program();
        programCotton.setProgramid(Constant.PROGRAM_COT_ID);
        programCotton.setName(context.getResources().getString(R.string.program_cotton));
        programCotton.setPictureVertical(R.mipmap.bg_cotton_vertical_s);
        programCotton.setPictureHorizontal(R.mipmap.bg_cotton_horizontal_s);
        Program programMix = new Program();
        programMix.setProgramid(Constant.PROGRAM_MIX_ID);
        programMix.setName(context.getResources().getString(R.string.program_mix));
        programMix.setPictureVertical(R.mipmap.bg_mix_vertical_s);
        programMix.setPictureHorizontal(R.mipmap.bg_mix_horizontal_s);
        Program programSyn = new Program();
        programSyn.setProgramid(Constant.PROGRAM_SYN_ID);
        programSyn.setName(context.getResources().getString(R.string.program_syn));
        programSyn.setPictureVertical(R.mipmap.bg_synthetics_vertical_s);
        programSyn.setPictureHorizontal(R.mipmap.bg_synthetics_horizontal_s);
        Program programChiffon = new Program();
        programChiffon.setProgramid(Constant.PROGRAM_CHI_ID);
        programChiffon.setName(context.getResources().getString(R.string.program_chiffon));
        programChiffon.setPictureVertical(R.mipmap.bg_chiffon_vertical_s);
        programChiffon.setPictureHorizontal(R.mipmap.bg_chiffon_horizontal_s);
        Program programAllergy = new Program();
        programAllergy.setProgramid(Constant.PROGRAM_ALL_ID);
        programAllergy.setName(context.getResources().getString(R.string.program_allergy));
        programAllergy.setPictureVertical(R.mipmap.bg_allergy_care_vertical_s);
        programAllergy.setPictureHorizontal(R.mipmap.bg_allergy_care_horizontal_s);
        Program programSuper = new Program();
        programSuper.setProgramid(Constant.PROGRAM_SUP_ID);
        programSuper.setName(context.getResources().getString(R.string.program_super));
        programSuper.setPictureVertical(R.mipmap.bg_super15_vertical_s);
        programSuper.setPictureHorizontal(R.mipmap.bg_super15_horizontal_s);
        Program programDown = new Program();
        programDown.setProgramid(Constant.PROGRAM_DOW_ID);
        programDown.setName(context.getResources().getString(R.string.program_down));
        programDown.setPictureHorizontal(R.mipmap.bg_down_horizontal_s);
        programDown.setPictureVertical(R.mipmap.bg_down_vertical_s);
        Program programOutdoor = new Program();
        programOutdoor.setProgramid(Constant.PROGRAM_OUT_ID);
        programOutdoor.setName(context.getResources().getString(R.string.program_outdoor));
        programOutdoor.setPictureVertical(R.mipmap.bg_outdoor_vertical_s);
        programOutdoor.setPictureHorizontal(R.mipmap.bg_outdoor_horizontal_s);
        Program programDeli = new Program();
        programDeli.setProgramid(Constant.PROGRAM_DEL_ID);
        programDeli.setName(context.getResources().getString(R.string.program_deli));
        programDeli.setPictureVertical(R.mipmap.bg_silk_vertical_s);
        programDeli.setPictureHorizontal(R.mipmap.bg_silk_horizontal_s);
        Program programWool = new Program();
        programWool.setProgramid(Constant.PROGRAM_WOO_ID);
        programWool.setName(context.getResources().getString(R.string.program_wool));
        programWool.setPictureVertical(R.mipmap.bg_wool_vertical_s);
        programWool.setPictureHorizontal(R.mipmap.bg_wool_horizontal_s);
        Program programShirts = new Program();
        programShirts.setProgramid(Constant.PROGRAM_SHI_ID);
        programShirts.setName(context.getResources().getString(R.string.program_shirts));
        programShirts.setPictureVertical(R.mipmap.bg_shirts_vertical_s);
        programShirts.setPictureHorizontal(R.mipmap.bg_shirts_horizontal_s);
        Program programOxygen = new Program();
        programOxygen.setProgramid(Constant.PROGRAM_ACT_ID);
        programOxygen.setName(context.getResources().getString(R.string.program_active));
        programOxygen.setPictureVertical(R.mipmap.bg_active_oxygen_refres_vertical_s);
        programOxygen.setPictureHorizontal(R.mipmap.bg_active_oxygen_refresh_horizontal_s);
        Program programSpin = new Program();
        programSpin.setProgramid(Constant.PROGRAM_SPI_ID);
        programSpin.setName(context.getResources().getString(R.string.program_spin));
        programSpin.setPictureVertical(R.mipmap.bg_spin_vertical_s);
        programSpin.setPictureHorizontal(R.mipmap.bg_spin_horizontal_s);
        Program programJeans = new Program();
        programJeans.setProgramid(Constant.PROGRAM_JEA_ID);
        programJeans.setName(context.getResources().getString(R.string.program_jeans));
        programJeans.setPictureVertical(R.mipmap.bg_jeans_vertical_s);
        programJeans.setPictureHorizontal(R.mipmap.bg_jeans_horizontal_s);
        Program programBed = new Program();
        programBed.setProgramid(Constant.PROGRAM_BED_ID);
        programBed.setName(context.getResources().getString(R.string.program_bedsheets));
        programBed.setPictureVertical(R.mipmap.bg_bedsheets_vertical_s);
        programBed.setPictureHorizontal(R.mipmap.bg_bedsheets_horizontal_s);
        Program programBabycare = new Program();
        programBabycare.setProgramid(Constant.PROGRAM_BAB_ID);
        programBabycare.setName(context.getResources().getString(R.string.program_baby));
        programBabycare.setPictureVertical(R.mipmap.bg_babywash_vertical_s);
        programBabycare.setPictureHorizontal(R.mipmap.bg_babywash_horizontal_s);
        Program programLarge = new Program();
        programLarge.setProgramid(Constant.PROGRAM_LAR_ID);
        programLarge.setName(context.getResources().getString(R.string.program_large));
        programLarge.setPictureVertical(R.mipmap.bg_largeitems_vertical_s);
        programLarge.setPictureHorizontal(R.mipmap.bg_largeitems_horizontal_s);

        Data data1 = new Data();
        data1.setProfileid(1);
        data1.setQuantity(6);
        data1.setTag(context.getResources().getString(R.string.tag_spring_summer));
        data1.setPicture(R.mipmap.img_spring_summer);
        ArrayList<Program> list1 = new ArrayList<>();
        list1.add(programCotton);
        list1.add(programMix);
        list1.add(programSyn);
        list1.add(programChiffon);
        list1.add(programAllergy);
        list1.add(programSuper);
        data1.setPrograms(list1);
        data1.setSelected(false);

        Data data2 = new Data();
        data2.setProfileid(2);
        data2.setQuantity(5);
        data2.setTag(context.getResources().getString(R.string.tag_autumn_winter));
        data2.setPicture(R.mipmap.img_autumn_winter);
        ArrayList<Program> list2 = new ArrayList<>();
        list2.add(programCotton);
        list2.add(programMix);
        list2.add(programSyn);
        list2.add(programDown);
        list2.add(programOutdoor);
        data2.setPrograms(list2);
        data2.setSelected(false);

        Data data3 = new Data();
        data3.setProfileid(3);
        data3.setQuantity(6);
        data3.setTag(context.getResources().getString(R.string.tag_fabric_obsessed));
        data3.setPicture(R.mipmap.img_fabric_obsessed);
        ArrayList<Program> list3 = new ArrayList<>();
        list3.add(programCotton);
        list3.add(programMix);
        list3.add(programDeli);
        list3.add(programWool);
        list3.add(programShirts);
        list3.add(programOxygen);
        data3.setPrograms(list3);
        data3.setSelected(false);

        Data data4 = new Data();
        data4.setProfileid(4);
        data4.setQuantity(5);
        data4.setTag(context.getResources().getString(R.string.tag_wash_daily));
        data4.setPicture(R.mipmap.img_wash_daily);
        ArrayList<Program> list4 = new ArrayList<>();
        list4.add(programCotton);
        list4.add(programMix);
        list4.add(programSyn);
        list4.add(programSuper);
        list4.add(programSpin);
        data4.setPrograms(list4);
        data4.setSelected(false);

        Data data5 = new Data();
        data5.setProfileid(5);
        data5.setQuantity(6);
        data5.setTag(context.getResources().getString(R.string.tag_wash_weekly));
        data5.setPicture(R.mipmap.img_wash_weekly);
        ArrayList<Program> list5 = new ArrayList<>();
        list5.add(programCotton);
        list5.add(programMix);
        list5.add(programSyn);
        list5.add(programJeans);
        list5.add(programBed);
        list5.add(programOxygen);
        data5.setPrograms(list5);
        data5.setSelected(false);

        Data data6 = new Data();
        data6.setProfileid(6);
        data6.setQuantity(5);
        data6.setTag(context.getResources().getString(R.string.tag_family_with_baby));
        data6.setPicture(R.mipmap.img_famliy_with_baby);
        ArrayList<Program> list6 = new ArrayList<>();
        list6.add(programCotton);
        list6.add(programMix);
        list6.add(programBabycare);
        list6.add(programOxygen);
        list6.add(programSpin);
        data6.setPrograms(list6);
        data6.setSelected(false);

        Data data7 = new Data();
        data7.setProfileid(7);
        data7.setQuantity(5);
        data7.setTag(context.getResources().getString(R.string.tag_three_gen));
        data7.setPicture(R.mipmap.img_three_generations);
        ArrayList<Program> list7 = new ArrayList<>();
        list7.add(programCotton);
        list7.add(programMix);
        list7.add(programSyn);
        list7.add(programLarge);
        list7.add(programSpin);
        data7.setPrograms(list7);
        data7.setSelected(false);

        ArrayList<Data> dataList = new ArrayList<>();
        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);
        dataList.add(data5);
        dataList.add(data6);
        dataList.add(data7);

        return dataList;
    }
}
