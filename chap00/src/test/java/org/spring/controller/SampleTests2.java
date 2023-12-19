package org.spring.controller;


import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//테스트 코드가 스프링을 실행하는 역할이라고 표시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/data.xml"})
@Log4j // Lombok을 이용해서 로그 기록하는 객체 생성
public class SampleTests2 {
	@Autowired(required = false)
	private ApplicationContext ctx;
		
	@Test
	public void dataSourceTest() {
		DataSource ds = (DataSource)ctx.getBean("datasource");
		try {
			
			log.info(ds.getConnection());
			log.info(123);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
