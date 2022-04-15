package com.laher.study.drools.automarketing.process;


import com.laher.study.drools.automarketing.components.BaseModule;
import com.laher.study.drools.automarketing.components.ConditionModule;

/**
 * 链接器
 *
 * @author laher
 * @date 2022-04-08
 */
public class Builder {

	public Builder(BaseModule currModule) {
		this.currModule = currModule;
	}

	/**当前组件**/
	public BaseModule currModule;

	/**下一个节点**/
	public Builder nextBuilder;

	/**
	 * 下个节点链路
	 */
	public Builder next(BaseModule nextModule) {
		this.nextBuilder = new Builder(nextModule);

		// 责任链
		return nextBuilder;
	}

	/**
	 * 下一个条件节点链路
	 */
	public BuilderCondition nextCondition(ConditionModule nextModule) {
		BuilderCondition builderCondition = new BuilderCondition(nextModule);
		this.nextBuilder = builderCondition;

		// 责任链
		return builderCondition;
	}

	@Override
	public String toString() {
		return builderDesc(this);
	}

	public String builderDesc(Builder builder) {
		if (builder.nextBuilder == null) {
			return builder.currModule.moduleName;
		}

		// 相同则只一个
		if (builder.currModule == builder.nextBuilder.currModule) {
			return "|";
		}

		return builder.currModule.moduleName + " -> " + builderDesc(builder.nextBuilder);
	}
}
