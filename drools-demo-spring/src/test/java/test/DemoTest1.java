/*
 * 深圳市惟客数据科技有限公司版权所有.
 */
package test;

import javax.annotation.Resource;

import com.laher.study.drools.DroolsDemoSpringApplication;
import com.laher.study.drools.entity.Item;
import com.laher.study.drools.entity.Order;
import com.laher.study.drools.services.CustomerServices;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 *
 * @author laher
 * @date 2022-04-15
 */
@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = DroolsDemoSpringApplication.class)
public class DemoTest1 {
	@Resource
	private CustomerServices customerServices;
	/**
	 * 满足200减30优惠
	 */
	@Test
	public void test1() {
		// 初始化数据
		customerServices.test1(generatorOrder1());
		customerServices.test1(generatorOrder2());
		// 输出结果：
		// 消费：155，优惠：0，实际支付：155
		// 消费：205，优惠：30，实际支付：175
	}
	private Order generatorOrder1() {
		Item item1 = new Item("洗发水", 15);
		Item item2 = new Item("瓷碗", 140);
		return new Order().add(item1, item2);
	}
	private Order generatorOrder2() {
		Item item1 = new Item("洗发水", 65);
		Item item2 = new Item("瓷碗", 140);
		return new Order().add(item1, item2);
	}
}