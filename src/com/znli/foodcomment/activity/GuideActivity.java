package com.znli.foodcomment.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.znli.foodcomment.R;
import com.znli.foodcomment.fragment.OneFragment;
import com.znli.foodcomment.fragment.ThreeFragment;
import com.znli.foodcomment.fragment.TwoFragment;



public class GuideActivity extends FragmentActivity{
private ViewPager vp_guide;
private FragmentManager fm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		init();
	}
	private void init() {
		vp_guide=(ViewPager) findViewById(R.id.vp_guide);
		GuideAdapter adapter = new GuideAdapter(getSupportFragmentManager());
		vp_guide.setAdapter(adapter);
	}
	private class  My extends FragmentPagerAdapter{

		public My(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	private class GuideAdapter extends FragmentPagerAdapter {

		private List<Fragment> list = new ArrayList<Fragment>();

		public GuideAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
			list.add(new OneFragment());
			list.add(new TwoFragment());
			list.add(new ThreeFragment(getApplicationContext()));
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return list.size();
		}
	}
}
