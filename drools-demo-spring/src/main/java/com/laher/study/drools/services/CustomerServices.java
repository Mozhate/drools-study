package com.laher.study.drools.services;

import javax.annotation.Resource;

import com.laher.study.drools.entity.Order;
import org.kie.api.runtime.KieSession;

import org.springframework.stereotype.Service;

/**
 * 业务
 *
 * @author laher
 * @date 2022-04-15
 */
@Service
public class CustomerServices {
	@Resource
	private KieSession kieSession;

	public void test1(Order order) {
		kieSession.insert(order);
		kieSession.fireAllRules();
		System.out.println("消费：" + order.money + "，优惠：" + order.preferentialMoney + "，实际支付：" + order.actualMoney);
	}
}
