package com.lqs.fast.mvpframework.base.adatpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dell on 2016/11/25.
 */

public class BaseVPAdatpter extends FragmentPagerAdapter{
    public BaseVPAdatpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
