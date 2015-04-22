package com.znli.foodcomment.activity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import com.znli.foodcomment.R;
import com.znli.foodcomment.R.layout;
import com.znli.foodcomment.bean.User;
import com.znli.foodcomment.dao.UserDao;
import com.znli.foodcomment.utils.ToastUtils;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends Activity {
	private EditText Registration_user;
	private EditText Registration_name;
	private EditText Registration_password;
	private EditText Registration_password2;
	UserDao userDao;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		//初始化
		init();
	}

	private void init() {
		Registration_user=(EditText) findViewById(R.id.Registration_user);
		Registration_name=(EditText) findViewById(R.id.Registration_name);
		Registration_password=(EditText) findViewById(R.id.Registration_password);
		Registration_password2=(EditText) findViewById(R.id.Registration_password2);
		userDao=new UserDao(this);
	}
	public void regist(View v){
		String userName = Registration_user.getText().toString().trim();
		String nickName = Registration_name.getText().toString().trim();
		String password = Registration_password.getText().toString().trim();
		String password2 = Registration_password2.getText().toString().trim();
		if("".equals(userName)||"".equals(nickName)||"".equals(password)||"".equals(password2)){
			ToastUtils.toast(this, "注册前请把信息补充完整！");
		}else{
		

			if(!password.equals(password2)){
				ToastUtils.toast(this, "密码与确认密码不一致！");
				return ;
			}
			if(userDao.getUser(userName)!=null){
				ToastUtils.toast(this, "用户名已经被使用");
				return ;
			}
			if(userDao.getUserfromNick(nickName)!=null){
				ToastUtils.toast(this, "用昵称已经被使用");
				return ;
			}
			
			userDao.add(new User(userName, -1, password, nickName));
			ToastUtils.toast(this, "注册成功");
			
			finish();
		}
	}
	
}

