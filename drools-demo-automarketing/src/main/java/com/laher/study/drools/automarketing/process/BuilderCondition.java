package com.laher.study.drools.automarketing.process;


import com.laher.study.drools.automarketing.components.BaseModule;
import com.laher.study.drools.automarketing.components.ConditionModule;

/**
 * 链接器
 *
 * @author laher
 * @date 2022-04-08
 */
public class BuilderCondition extends Builder {

	/**成功节点**/
	public Builder okBuilder;

	/**错误节点**/
	public Builder noBuilder;


	public BuilderCondition(ConditionModule currModule) {
		super(currModule);
		this.currModule = currModule;
	}

	/**
	 * 成功节点下一步
	 */
	public Builder ok(BaseModule nextModule) {
		this.okBuilder = new Builder(nextModule);

		// 责任链
		return okBuilder;
	}

	/**
	 * 错误节点下一步
	 */
	public Builder no(BaseModule nextModule) {
		this.noBuilder = new Builder(nextModule);

		// 责任链
		return noBuilder;
	}
}
