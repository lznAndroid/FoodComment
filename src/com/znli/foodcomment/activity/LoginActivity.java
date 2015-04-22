package com.znli.foodcomment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.znli.foodcomment.R;
import com.znli.foodcomment.bean.User;
import com.znli.foodcomment.dao.UserDao;
import com.znli.foodcomment.utils.SpUtils;
import com.znli.foodcomment.utils.ToastUtils;

public class LoginActivity extends Activity {
	private EditText Login_user;
	private EditText Login_password;
	private UserDao userdao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		//初始化
		init();
	}

	private void init() {
		String userName = SpUtils.getInstance(this).getString(SpUtils.USERNAME, "");
		Login_user=(EditText) findViewById(R.id.Login_user);
		Login_password=(EditText) findViewById(R.id.Login_password);
		userdao=new UserDao(this);
		if(!"".equals(userName)){
			Login_user.setText(userName);
		}
	}
	public void login(View v){
		Log.e("TAG", "login");
		final String userName=Login_user.getText().toString().trim();
		final String password=Login_password.getText().toString().trim();
		if("".equals(userName)){
			ToastUtils.toast(this, "亲，您还没有输入用户账号");
			return;
		}
		if("".equals(password)){
			ToastUtils.toast(this, "亲，您还没有输入密码");
			return;
		}
		
		
		new AsyncTask<Void, Void, Boolean>() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				
			}
			@Override
			protected Boolean doInBackground(Void... params) {
				return userdao.query(new User(userName, -1, password, null));
			}
			@Override
			protected void onPostExecute(Boolean result) {
				super.onPostExecute(result);
				if(result){
					finish();
					SpUtils.getInstance(getApplicationContext()).save(SpUtils.USERNAME, userName);
					
					startActivity(new Intent(getApplicationContext(), MainActivity.class));
					
				}else{
					ToastUtils.toast(getApplicationContext(), "对不起，您的用户名不存在或密码不正确");
					
				}
			}
		}.execute();
	
		
	}
	public void regist(View v){
		Log.e("TAG", "regist");
		startActivity(new Intent(this, RegistActivity.class));
	}
	public void forget(View v){
		ToastUtils.toast(this, "已点击忘记密码");
	}
	
}
