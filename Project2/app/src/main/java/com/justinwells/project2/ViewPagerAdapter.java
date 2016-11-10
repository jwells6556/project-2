package com.justinwells.project2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * Created by justinwells on 11/7/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TopRatedFragment();
            case 1: return new ActionFragment();
            case 2: return new HorrorFragment();
            case 3: return new ComedyFragment();
            case 4: return null;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "TOP RATED";
            case 1: return "ACTION";
            case 2: return "HORROR";
            case 3: return "COMEDY";
            case 4: return null;
            default: return null;
        }
    }
}
