package com.znli.foodcomment.fragment;

import com.znli.foodcomment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return View.inflate(getActivity(), R.layout.fragment_my, null);
	}
}
