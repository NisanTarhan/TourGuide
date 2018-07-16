package com.example.nisan.tourguide;


import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class CategoryAdapter extends FragmentPagerAdapter{

    private final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Landmarks", "Museums", "Restaurants", "Shopping" };


    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LandmarkFragment();
        } else if (position == 1){
            return new MuseumFragment();
        } else if (position == 2) {
            return new RestaurantFragment();
        } else {
            return new ShoppingFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
