package com.laher.study.drools.automarketing.components;

/**
 * 条件组件
 *
 * @author laher
 * @date 2022-04-08
 */
public class ConditionModule extends BaseModule {
	public ConditionModule() {
		moduleName = "条件组件";
	}

	public ConditionModule(String cond, String symbol, Integer value) {
		moduleName = "条件组件";
		this.cond = cond;
		this.symbol = symbol;
		this.value = value;
	}

	/**条件 积分、年龄、级别、消费金额**/
	public String cond;

	/**符号 > = < **/
	public String symbol;

	/** 条件比较值 **/
	public Object value;

	/** 执行 **/
	@Override
	public void exec() {

	}
}
