package com.rosenray.ormlitedemo.model.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.rosenray.ormlitedemo.model.dao.bean.AddressBean;
import com.rosenray.ormlitedemo.model.dao.bean.UserBean;

import java.sql.SQLException;

/**
 * Created by RosenRay on 2016/12/25.
 * 项目名 TakeOut
 * 类名   DBHelper
 * 描述:
 */

public class DBHelper extends OrmLiteSqliteOpenHelper{

	private static final String DATABASENAME = "itheima.db";
	private static final int DATABASEVERSION = 1;

	public DBHelper(Context context) {
		super(context, DATABASENAME, null, DATABASEVERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, UserBean.class);
			TableUtils.createTable(connectionSource, AddressBean.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

	}
}
