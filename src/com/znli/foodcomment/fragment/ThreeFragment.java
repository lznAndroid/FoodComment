package com.znli.foodcomment.fragment;

import com.znli.foodcomment.R;
import com.znli.foodcomment.activity.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ThreeFragment extends Fragment implements OnClickListener {
	private Context context;
	public ThreeFragment(Context context) {
		super();
		this.context=context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=View.inflate(getActivity(), R.layout.guide_my03, null);
		ImageView iv_guide_skip=(ImageView) view.findViewById(R.id.iv_guide_skip);
		iv_guide_skip.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		getActivity().finish();
		startActivity(new Intent(context, LoginActivity.class));
	}
}
