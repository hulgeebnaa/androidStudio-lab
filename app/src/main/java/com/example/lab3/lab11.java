package com.example.lab3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class lab11 extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager  viewPager;
    private int[] tabIcons = {
            R.drawable.apple,
            R.drawable.grape,
            R.drawable.banana,
            R.drawable.orange
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11);
        this.getSupportActionBar().hide();

            tabLayout = (TabLayout) findViewById(R.id.tablayout);
            viewPager = (ViewPager) findViewById(R.id.myViewPager);
        ViewPagerAdapter viewPageAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragment(AppleFragment.getInstance(), "Apple");
        viewPageAdapter.addFragment(GrapeFragment.getInstance(), "Grape");
        viewPageAdapter.addFragment(BananaFragment.getInstance(), "Banana");
        viewPageAdapter.addFragment(OrangeFragment.getInstance(), "Orange");
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

}