package com.korhacker.stopsmokemng;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int mNumOfSmoke;
    TextView mTv_numOfSmoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* 오늘 핀 개비수 표시 */
        mTv_numOfSmoke = (TextView) findViewById(R.id.main_tv_numOfSmoke);
        mNumOfSmoke = Integer.parseInt(mTv_numOfSmoke.getText().toString());

        /* 오늘 날짜 표시 */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
        String strDate = sdf.format(calendar.getTime());
        ((TextView) findViewById(R.id.main_tv_date)).setText(strDate);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.main_fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNumOfSmoke++;
                mTv_numOfSmoke.setText(""+mNumOfSmoke);
                Snackbar.make(view, "add num of smoke", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            }
        });

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add fragments to adapter one by one
        adapter.addFragment(new GraphTimeFragment(), "Time");
        adapter.addFragment(new GraphDayFragment(), "Day");
        adapter.addFragment(new GraphMonthFragment(), "Month");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}