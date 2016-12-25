package com.rosenray.ormlitedemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.j256.ormlite.dao.Dao;
import com.rosenray.ormlitedemo.model.dao.DBHelper;
import com.rosenray.ormlitedemo.model.dao.bean.AddressBean;
import com.rosenray.ormlitedemo.model.dao.bean.UserBean;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
	private Context appContext;
	@Test
	public void useAppContext() throws Exception {
		// Context of the app under test.
		Context appContext = InstrumentationRegistry.getTargetContext();

		assertEquals("com.rosenray.ormlitedemo", appContext.getPackageName());
	}

	/**
	 * 创建数据库
	 */
	@Test
	public void testCreate() {
		appContext = InstrumentationRegistry.getTargetContext();
		DBHelper dbHelper = new DBHelper(appContext);
		dbHelper.getWritableDatabase();
	}

	/**
	 * 增加数据到t_user表中
	 */
	@Test
	public void testInsert() throws SQLException {
		appContext = InstrumentationRegistry.getTargetContext();
		DBHelper helper = new DBHelper(appContext);
		Dao<UserBean, Integer> dao = helper.getDao(UserBean.class);
		UserBean userBean = new UserBean();
		userBean.set_id(1);
		dao.create(userBean);
		UserBean userBean1 = new UserBean();
		userBean1.set_id(2);
		dao.create(userBean1);
	}

	/**
	 * 对外键id为2添加10条地址数据
	 */
	@Test
	public void testInsertAddress() throws SQLException {
		appContext = InstrumentationRegistry.getTargetContext();
		DBHelper helper = new DBHelper(appContext);
		Dao<AddressBean, Integer> dao = helper.getDao(AddressBean.class);
		UserBean userBean = new UserBean();
		userBean.set_id(2);
		for (int i = 1; i < 10; i++) {
			AddressBean addressBean = new AddressBean(userBean);
			addressBean.set_id(i);
			addressBean.setGoodsAddress("长沙高新区辰泰科技园" + i);
			addressBean.setVillage("98号");
			dao.create(addressBean);
		}

	}

	/**
	 * 针对id为2的user查询收货地址
	 */
	@Test
	public void queryDemo() throws SQLException {
		appContext = InstrumentationRegistry.getTargetContext();
		DBHelper helper = new DBHelper(appContext);
		Dao<UserBean, Integer> dao = helper.getDao(UserBean.class);
		UserBean userBean = dao.queryForId(2);
		System.out.println(userBean.toString());
	}

}
