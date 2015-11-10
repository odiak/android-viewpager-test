package net.odiak.viewpagertest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
//        viewPager.setAdapter(new TestPagerAdapter(this));

        FragmentManager fm = getSupportFragmentManager();
        TestFragmentPagerAdapter adapter = new TestFragmentPagerAdapter(fm);
        viewPager.setAdapter(adapter);
    }

    private static class TestPagerAdapter extends PagerAdapter {
        private Context mContext;
        private static final int PAGE_COUNT = 10;

        public TestPagerAdapter(Context context) {
            super();
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(mContext);
            textView.setText(String.format("item %d", position));
            container.addView(textView);

            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    private static class TestFragmentPagerAdapter extends FragmentStatePagerAdapter {
        private static final int PAGE_COUNT = 10;

        public TestFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            System.out.printf("# getItem(%d)\n", position);
            return TestFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
