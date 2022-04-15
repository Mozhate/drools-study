package com.laher.study.drools.automarketing.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 *
 * @author laher
 * @date 2022-04-08
 */
public class User {

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, Integer age,Integer integral) {
		this.name = name;
		this.age = age;
		this.integral = integral;
	}

	/**用户**/
	public String name;

	/**总积分**/
	public Integer integral = 0;

	/**级别**/
	public Integer level;

	/**消费金额**/
	public Double consumerAmount = 0D;

	/**年龄**/
	public Integer age;

	/**优惠券**/
	public List<String> coupons = new ArrayList<>();

	public void addCoupon(String couponName) {
		coupons.add(couponName);
	}

	public Comparable getValue(String param){
		switch (param){
			case "积分":
				return this.integral;
			case "年龄":
				return this.age;
			case "级别":
				return this.level;
			case "消费金额":
				return this.consumerAmount;
			default:
				return 0;
		}
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", integral=" + integral +
				", level=" + level +
				", consumerAmount=" + consumerAmount +
				", age=" + age +
				", coupons=" + coupons +
				'}';
	}
}
