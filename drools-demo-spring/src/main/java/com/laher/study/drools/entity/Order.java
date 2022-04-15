package com.laher.study.drools.entity;

import java.util.Arrays;
import java.util.List;

/**
 * 订单
 *
 * @author laher
 * @date 2022-04-15
 */
public class Order {
	/** 消费金额 **/
	public Integer money = 0;
	/** 优惠金额 **/
	public Integer preferentialMoney = 0;
	/** 实际消费金额 **/
	public Integer actualMoney = 0;
	/** 购物列表 **/
	public List<Item> items;

	public Order add(Item... items) {
		this.items = Arrays.asList(items);
		return this;
	}
}
