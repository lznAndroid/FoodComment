package com.znli.foodcomment.activity;

import java.util.ArrayList;
import java.util.List;

import com.znli.foodcomment.R;
import com.znli.foodcomment.R.layout;
import com.znli.foodcomment.fragment.CheckInFragment;
import com.znli.foodcomment.fragment.MoreFragment;
import com.znli.foodcomment.fragment.MyFragment;
import com.znli.foodcomment.fragment.SearchFragment;
import com.znli.foodcomment.fragment.TuanFragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	private ViewPager vp_main;
	private List<LinearLayout> tabLLs;
	List<ImageView> tabIVs=new ArrayList<ImageView>();
	List<TextView> tabTVs=new ArrayList<TextView>();
	private int currentPos; // 当前页的下标

	private List<Integer> tabNormalIcons = new ArrayList<Integer>();// 正常的
	private List<Integer> tabSelectedIcons = new ArrayList<Integer>();// 选中的
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	private void init() {
		vp_main=(ViewPager) findViewById(R.id.vp_main);
		tabNormalIcons.add(R.drawable.main_index_search_normal);
		tabNormalIcons.add(R.drawable.main_index_tuan_normal);
		tabNormalIcons.add(R.drawable.main_index_checkin_normal);
		tabNormalIcons.add(R.drawable.main_index_my_normal);
		tabNormalIcons.add(R.drawable.main_index_more_normal);
		
		tabSelectedIcons.add(R.drawable.main_index_search_pressed);
		tabSelectedIcons.add(R.drawable.main_index_tuan_pressed);
		tabSelectedIcons.add(R.drawable.main_index_checkin_pressed);
		tabSelectedIcons.add(R.drawable.main_index_my_pressed);
		tabSelectedIcons.add(R.drawable.main_index_more_pressed);
		
		tabIVs.add((ImageView) findViewById(R.id.iv_main_tap_search));
		tabIVs.add((ImageView) findViewById(R.id.iv_main_tap_tuan));
		tabIVs.add((ImageView) findViewById(R.id.iv_main_tap_checkin));
		tabIVs.add((ImageView) findViewById(R.id.iv_main_tap_my));
		tabIVs.add((ImageView) findViewById(R.id.iv_main_tap_more ));
		
		tabTVs.add((TextView) findViewById(R.id.tv_main_tap_search ));
		tabTVs.add((TextView) findViewById(R.id.tv_main_tap_tuan));
		tabTVs.add((TextView) findViewById(R.id.tv_main_tap_checkin));
		tabTVs.add((TextView) findViewById(R.id.tv_main_tap_my ));
		tabTVs.add((TextView) findViewById(R.id.tv_main_tap_more ));
		vp_main.setAdapter(new MainAdapter(getSupportFragmentManager()));
		// 添加滑动的监听
		vp_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				updateTab(position);
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
			}

			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
	}
	private void updateTab(int position) {
		if (currentPos != position) {
			// 1. currentPos所对应的tab项变为正常状态(图片,文本颜色)
			tabIVs.get(currentPos).setImageResource(tabNormalIcons.get(currentPos));
			tabTVs.get(currentPos).setTextColor(Color.WHITE);
			// 2. position所对应的tab项变为选中的状态(图片,文本颜色)
			tabIVs.get(position).setImageResource(tabSelectedIcons.get(position));
			tabTVs.get(position).setTextColor(Color.parseColor("#FF8C00"));
			//3. 更新currentPos
			currentPos = position;
		}

	}
	class MainAdapter extends FragmentPagerAdapter {

		List<Fragment> fragments = new ArrayList<Fragment>();

		public MainAdapter(FragmentManager fm) {
			super(fm);
			fragments.add(new SearchFragment());
			fragments.add(new TuanFragment());
			fragments.add(new CheckInFragment());
			fragments.add(new MyFragment());
			fragments.add(new MoreFragment());
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}
	}
}
