package com.laher.study.drools.automarketing.components;

/**
 * 优惠券组件
 *
 * @author laher
 * @date 2022-04-08
 */
public class CouponModule extends BaseModule {
	public CouponModule() {
		moduleName = "优惠券组件";
	}

	public CouponModule(String couponName) {
		moduleName = "优惠券组件";
		this.couponName = couponName;
	}

	/**发放优惠券**/
	public String couponName;

	/** 执行 **/
	@Override
	public void exec() {

	}
}
