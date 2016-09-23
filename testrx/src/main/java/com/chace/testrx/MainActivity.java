package com.chace.testrx;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.chace.testrx.module.basefeature.view.ElementaryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolBar)     Toolbar mToolbar;
    @BindView(R.id.tabLayout)   TabLayout mTabLayout;
    @BindView(R.id.viewPage)    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Chace Test RxJava");

        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                case 0:
                    return  new ElementaryFragment();
                default:
                    return new ElementaryFragment();
                }
            }

            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "基本";
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
