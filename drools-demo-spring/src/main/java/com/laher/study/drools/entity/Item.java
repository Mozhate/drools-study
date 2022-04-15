package com.laher.study.drools.entity;

/**
 * 商品
 *
 * @author laher
 * @date 2022-04-15
 */
public class Item {

	/** 名称 **/
	public String name;
	/** 金额 **/
	public Integer money;

	public Item(String name, Integer money) {
		this.name = name;
		this.money = money;
	}

	public Integer getMoney() {
		return money;
	}
}
