package com.rosenray.ormlitedemo.model.dao.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by RosenRay on 2016/12/25.
 * 项目名 TakeOut
 * 类名   AddressBean
 * 描述:
 */
@DatabaseTable(tableName = "t_address")
public class AddressBean {

	@DatabaseField(id = true)
	private int _id;
	@DatabaseField(canBeNull = false)
	private String goodsAddress;
	@DatabaseField(canBeNull = false)
	private String village;

	@DatabaseField(canBeNull = false, foreign = true, foreignColumnName = "_id", columnName = "user_id")
	private UserBean user;

	public AddressBean(UserBean user) {
		this.user = user;
	}

	public AddressBean() {
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getGoodsAddress() {
		return goodsAddress;
	}

	public void setGoodsAddress(String goodsAddress) {
		this.goodsAddress = goodsAddress;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

}

