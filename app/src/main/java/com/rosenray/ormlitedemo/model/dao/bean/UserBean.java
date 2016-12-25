package com.rosenray.ormlitedemo.model.dao.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by RosenRay on 2016/12/25.
 * 项目名 TakeOut
 * 类名   UserBean
 * 描述:
 */
@DatabaseTable(tableName = "t_user")
public class UserBean {
	@DatabaseField(columnName = "_id",id = true)
	private int _id;
	//需要一个集合去装当前用户的所欲地址列表信息
	@ForeignCollectionField(eager = true)
	private ForeignCollection<AddressBean> addressList;

	public UserBean() {
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}
}
