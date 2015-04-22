package com.znli.foodcomment.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
	public static void toast(Context context, String string){
		Toast.makeText(context, string, 0).show();
	}
}
