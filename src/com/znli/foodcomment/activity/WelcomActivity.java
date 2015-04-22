package com.znli.foodcomment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.LinearLayout;

import com.znli.foodcomment.R;

public class WelcomActivity extends Activity {
private LinearLayout ll_welcome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcom);
		init();
	}
	private void init() {
		ll_welcome=(LinearLayout) findViewById(R.id.ll_welcome);
		startAnnimation();
		doWork();
	}
	private void doWork() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				SystemClock.sleep(2000);
				
				//判断是否是第一次启动此应用
				startActivity(new Intent(getApplicationContext(), GuideActivity.class));
				finish();
			}
		}).start();
	}
	private void startAnnimation() {
		ll_welcome.animate().alphaBy(0.0f).alpha(1.0f).setDuration(2000).start();
	}
}
