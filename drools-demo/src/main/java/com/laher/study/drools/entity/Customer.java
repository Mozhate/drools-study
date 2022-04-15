package com.laher.study.drools.entity;

/**
 * 客户类
 *
 * @author laher
 * @date 2022-04-15
 */
public class Customer {

	/** 姓名 **/
	public String name;

	/** 消费金额 **/
	public Integer money;

	public Customer(String name, Integer money) {
		this.name = name;
		this.money = money;
	}
}
