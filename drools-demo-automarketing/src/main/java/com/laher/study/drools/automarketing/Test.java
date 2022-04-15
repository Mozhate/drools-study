package com.laher.study.drools.automarketing;

import com.laher.study.drools.automarketing.components.ConditionModule;
import com.laher.study.drools.automarketing.components.CouponModule;
import com.laher.study.drools.automarketing.components.EndModule;
import com.laher.study.drools.automarketing.components.IntegralModule;
import com.laher.study.drools.automarketing.components.StartModule;
import com.laher.study.drools.automarketing.entity.User;
import com.laher.study.drools.automarketing.process.Builder;
import com.laher.study.drools.automarketing.process.BuilderCondition;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * 测试
 *
 * @author laher
 * @date 2022-04-08
 */
public class Test {

	public static void main(String[] args) {
		// 案例1：发放优惠券，开始组件 -> 优惠券组件 -> 结束组件
//		marketing_01();
		// 案例1：条件发放优惠券和积分
		marketing_02();

	}

	/**
	 * 自动化营销案例 1
	 */
	public static void marketing_01() {
		// 创建流程 开始组件 -> 优惠券组件 -> 结束组件
		StartModule startModule = new StartModule();
		CouponModule couponModule = new CouponModule("满100元减10元优惠券");
		EndModule endModule = new EndModule();

		// 链接流程
		Builder builder = new Builder(startModule);
		builder.next(couponModule).next(endModule);

		System.out.println("链路描述：" + builder);

		// 创建用户
		User user = new User("张三");

		// drools初始化
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		// 创建会话、填充参数、执行所有规则
		KieSession kSession = kContainer.newKieSession();
		// 打印
		kSession.setGlobal("out", System.out);

		// 参数填充
		kSession.insert(builder);
		kSession.insert(user);

		// 执行所有规则
		kSession.fireAllRules();

		// 打印用户优惠券
		System.out.println(user);
	}

	/**
	 * 自动化营销案例 2
	 */
	public static void marketing_02() {
		// 创建流程
		StartModule startModule = new StartModule();
		CouponModule couponModule = new CouponModule("满100元减10元优惠券");
		IntegralModule integralModule = new IntegralModule(100);
		EndModule endModule = new EndModule();

		// 创建条件组件
		ConditionModule conditionModule = new ConditionModule("年龄", "<", 100);

		// 链接流程
		KieServices ks = KieServices.Factory.get();
		Builder builder = new Builder(startModule);
		// 增加条件流程
		BuilderCondition builderCondition = builder.nextCondition(conditionModule);
		// -- 满足条件则发放优惠券、积分在结束
		builderCondition.ok(couponModule).next(integralModule).next(endModule);
		// -- 不满足条件则结束
		builderCondition.no(endModule);

		// 链路描述：
		// 开始组件 -> 条件组件 (成功)-> 优惠券组件 -> 积分组件 -> 结束组件
		// 					 (失败)-> 结束组件

		// 创建用户
		User user = new User("张三", 18,9);

		// drools初始化
		KieContainer kContainer = ks.getKieClasspathContainer();

		// 创建会话、填充参数、执行所有规则
		KieSession kSession = kContainer.newKieSession();
		// 打印
		kSession.setGlobal("out", System.out);

		// 参数填充
		kSession.insert(builder);
		kSession.insert(user);

		// 执行所有规则
		kSession.fireAllRules();

		// 打印用户优惠券
		System.out.println(user);
	}

}
