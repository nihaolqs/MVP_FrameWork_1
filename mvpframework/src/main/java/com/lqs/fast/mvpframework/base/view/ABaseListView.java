package com.lqs.fast.mvpframework.base.view;

import com.lqs.fast.mvpframework.bean.vo.IListVO;

import java.util.ArrayList;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABaseListView<VO extends IListVO> extends ABaseView{
    private ArrayList<VO> mVoArrayList = new ArrayList<>();

}
