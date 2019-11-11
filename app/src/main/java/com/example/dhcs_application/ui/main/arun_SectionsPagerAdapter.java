package com.example.dhcs_application.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dhcs_application.AnnouncementInstructors;
import com.example.dhcs_application.R;
import com.example.dhcs_application.arun_Frag1;
import com.example.dhcs_application.arun_Frag2;
import com.example.dhcs_application.arun_Frag3;

/**r
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class arun_SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.instructor_tab1, R.string.instructor_tab2};
    private final Context mContext;

    public arun_SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new arun_Frag1();
                break;
            case 1:
                frag = new AnnouncementInstructors();
                break;
//            case 2:
//                frag = new arun_Frag3();
//                break;
        }
        return frag;
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}