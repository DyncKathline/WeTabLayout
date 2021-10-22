package com.we.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.we.tablayout.IHandleTab;
import cn.we.tablayout.WeTabLayout;
import cn.we.tablayout.OnTabSelectedListener;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WeTabLayout tabLayout = findViewById(R.id.dil_tablayout);



        ViewPager viewPager = findViewById(R.id.viewpager);
        final String[] titles = {"移动", "四个字的", "小灵通", "这个很长电影啊", "NBA", "电影", "小知识", "篮球"};
        final String[] titlesTwo = {"移动", "四个字的", "小灵通"};

        tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(WeTabLayout.Tab tab) {
                Log.i("TAG",  "onTabSelected:==== " + tab.getPosition());
                if(tab.targetView instanceof LinearLayout) {
                    TextView tv_tab_title = tab.targetView.findViewById(R.id.tv_tab_title);
                    tabLayout.setSelectedTabStyle(tv_tab_title, true);
                }
            }

            @Override
            public void onPreTabSelected(WeTabLayout.Tab tab) {
                Log.i("TAG",  "onPreTabSelected:==== " + tab.getPosition());
                if(tab.targetView instanceof LinearLayout) {
                    TextView tv_tab_title = tab.targetView.findViewById(R.id.tv_tab_title);
                    tabLayout.setSelectedTabStyle(tv_tab_title, false);
                }
            }
        });
        tabLayout.addHandleTabCallBack(new IHandleTab() {
            @Override
            public void addTab(View tab, int index) {

            }
        });
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return CeshiFragment.newInstance();
            }

            @Override
            public int getCount() {
                return titlesTwo.length;
            }
        });

//        tabLayout.setTabContainerGravity(Gravity.LEFT);
//        tabLayout.setIndicatorResId(R.mipmap.ic_vip_logo);
        tabLayout.setupWithViewPager(null, titlesTwo);

//        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.item_sliding_tab_layout));
//        tabLayout.addTab(tabLayout.newTab().setText("移动"));
//        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.item_sliding_tab_layout));
//        tabLayout.setCurrentTab(1);

    }
}
