package com.znli.foodcomment.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

public static final String TABLE_BLACK_NUMBER ="black_number";
	
	public DBhelper(Context context) {
		super(context, "food.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//创建表
		db.execSQL("create table user(_id integer primary key autoincrement, user_name varchar  unique,password varchar,nick_name varchar unique)");
		db.execSQL("create table shop(_id integer primary key autoincrement, shop_name varchar , icon integer, city varchar,area varchar,street varchar)");
		db.execSQL("create table comment(_id integer primary key autoincrement, nick_name varchar  ,shop_id varchar,speak varchar,agree varchar,oppose varchar)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
