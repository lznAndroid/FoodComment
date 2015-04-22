package com.znli.foodcomment.dao;

import java.util.Currency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.znli.foodcomment.bean.User;

public class UserDao {
	private DBhelper dbhelper;
	public static final String USER="user";
	public static final String USER_NAME="user_name";
	public static final String PASSWORD="password";
	public static final String NICK_NAME="nick_name";
	public UserDao(Context context) {
		dbhelper=new DBhelper(context);
	}
	public void add(User user){
		SQLiteDatabase database = dbhelper.getReadableDatabase();
		ContentValues values=new ContentValues();
		values.put(USER_NAME, user.getName());
		values.put(PASSWORD, user.getPassword());
		values.put(NICK_NAME, user.getNickName());
		long id = database.insert(USER, null, values);
		Log.e("TAG", "add "+id);
		database.close();
	}
	public void update(User user){
		SQLiteDatabase database = dbhelper.getReadableDatabase();
		ContentValues values=new ContentValues();
		values.put(PASSWORD, user.getPassword());
		int update = database.update(USER, values, "_id=?", new String[]{user.getId()+""});
		Log.e("TAG", "update "+update);
		database.close();
	}
	public boolean query(User user){
		boolean isHava;
		SQLiteDatabase database = dbhelper.getReadableDatabase();
		String sql="select* from user where  user_name=? and password=?";
		
		Cursor cursor = database.rawQuery(sql, new String[]{user.getName(),user.getPassword()});
		isHava=cursor.moveToNext();
		Log.e("TAG", "isHava "+isHava);
		cursor.close();
		database.close();
		return isHava;
	}
	public User getUser(String userName){
		User user = null;
		SQLiteDatabase database = dbhelper.getReadableDatabase();
		Cursor cursor = database.rawQuery("select* from user where user_name=?", new String[]{userName});
		if(cursor.moveToNext()){
			int id = cursor.getInt(0);
			String userName1 = cursor.getString(1);
			String password = cursor.getString(2);
			String nickName = cursor.getString(3);
			user=new User(userName1, id, password, nickName);
		}
		cursor.close();
		database.close();
		return user;
	}
	public User getUserfromNick(String nickName){
		User user = null;
		SQLiteDatabase database = dbhelper.getReadableDatabase();
		Cursor cursor = database.rawQuery("select* from user where nick_name=?", new String[]{nickName});
		if(cursor.moveToNext()){
			int id = cursor.getInt(0);
			String userName1 = cursor.getString(1);
			String password = cursor.getString(2);
			String nickName1 = cursor.getString(3);
			user=new User(userName1, id, password, nickName1);
		}
		cursor.close();
		database.close();
		return user;
	}
}
