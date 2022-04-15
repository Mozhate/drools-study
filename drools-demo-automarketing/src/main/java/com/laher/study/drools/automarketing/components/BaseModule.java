package com.laher.study.drools.automarketing.components;

/**
 * 基准组件
 *
 * @author laher
 * @date 2022-04-08
 */
public abstract class BaseModule {
	/** 组件名称**/
	public String moduleName;

	/** 下一个组件 **/
//	public BaseModule next;

	/** 执行 **/
	public abstract void exec();

}
