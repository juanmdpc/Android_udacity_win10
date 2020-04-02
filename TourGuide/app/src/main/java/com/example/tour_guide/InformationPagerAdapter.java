package com.example.tour_guide;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * {@link InformationPagerAdapter} is a {@link FragmentPagerAdapter} that can provide
 * the layout for each list item on a data source which is a list of {@link Information} objects.
 */
public class InformationPagerAdapter extends FragmentPagerAdapter
{
    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link InformationPagerAdapter} object.
     * @param fm is the fragment manager that will keep each fragment's state in the adapter across swipes.
     * @param context is the context of the activity.
     */
    public InformationPagerAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        mContext = context;
    }

    /**
     * @return the total number of pages.
     */
    @Override
    public int getCount()
    {
        return 4;
    }

    /**
     *
     * @param position is the number of page swiped.
     * @return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new RestaurantsFragment();
            case 1:
                return new MuseumsFragment();
            case 2:
                return new PlacesFragment();
            default:
                return new SlangFragment();
        }
    }

    /**
     *
     * @param position is the number of page selected.
     * @return the {@link CharSequence} that should tab name for the given page.
     */
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return mContext.getString(R.string.category_restaurants);
            case 1:
                return mContext.getString(R.string.category_museums);
            case 2:
                return mContext.getString(R.string.category_tourist_places);
            default:
                return mContext.getString(R.string.category_slang);
        }
    }
}
