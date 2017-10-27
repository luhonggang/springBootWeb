package com.sanlen;

import com.sanlen.entity.Customers;
import com.sanlen.mapper.CustomersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringApplicatioTest {
	@Autowired
	private CustomersMapper customersMapper;

	@Test
	public void contextLoads() {
		List<Customers> c = customersMapper.selectByPrimaryKey(103);
		for (Customers c1:c) {
			System.out.println("信息是 : "+c1.getCustomername() +" 顾客的信息是 : "+c1.getPhone());
		}
	}

}
