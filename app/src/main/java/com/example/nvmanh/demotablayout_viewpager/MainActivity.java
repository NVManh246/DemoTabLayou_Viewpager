package com.example.nvmanh.demotablayout_viewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nvmanh.demotablayout_viewpager.fragment.OneFragment;
import com.example.nvmanh.demotablayout_viewpager.fragment.ThreeFragment;
import com.example.nvmanh.demotablayout_viewpager.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private List<Integer> mIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setView();
    }

    private void initView(){
        mTabLayout = findViewById(R.id.tablayout_demo);
        mViewPager = findViewById(R.id.viewpager_demo);
    }


    private void initData(){
        mTitles = new ArrayList<>();
        mTitles.add(getString(R.string.one));
        mTitles.add(getString(R.string.two));
        mTitles.add(getString(R.string.three));

        mFragments = new ArrayList<>();
        mFragments.add(new OneFragment());
        mFragments.add(new TwoFragment());
        mFragments.add(new ThreeFragment());

        mIcons = new ArrayList<>();
        mIcons.add(R.drawable.ic_favorite_black_24dp);
        mIcons.add(R.drawable.ic_fiber_manual_record_black_24dp);
        mIcons.add(R.drawable.ic_grade_black_24dp);
    }

    private void setView(){
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mPagerAdapter.notifyDataSetChanged();
        setupTabIcon();
    }

    private void setupTabIcon() {
        for (int i = 0; i < mIcons.size(); i++) {
            mTabLayout.getTabAt(i).setIcon(mIcons.get(i));
        }
    }
}
