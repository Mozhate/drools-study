package com.laher.study.drools.automarketing.components;

/**
 * 积分组件
 *
 * @author laher
 * @date 2022-04-08
 */
public class IntegralModule extends BaseModule {
	public IntegralModule() {
		moduleName = "积分组件";
	}

	public IntegralModule(Integer value) {
		moduleName = "积分组件";
		this.value = value;
	}

	/**发放积分量**/
	public Integer value;

	/** 执行 **/
	@Override
	public void exec() {

	}
}
