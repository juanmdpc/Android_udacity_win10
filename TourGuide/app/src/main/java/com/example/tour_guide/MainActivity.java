package com.example.tour_guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page.
        PagerAdapter adapter = new InformationPagerAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager.
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs.
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Connect the tab layout with the view pager. This will
        // 1. Update the tab layout when the view pager is swiped.
        // 2. Update the view pager when a tab is selected.
        // 3. Set the tab layout's tab names with the view pager's adapter's titles
        // by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

    }
}
