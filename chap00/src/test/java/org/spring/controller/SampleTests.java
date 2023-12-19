package org.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.samlpe.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//테스트 코드가 스프링을 실행하는 역할이라고 표시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j // Lombok을 이용해서 로그 기록하는 객체 생성
public class SampleTests {
	@Autowired(required = false)
	private Restaurant rst;
		
	@Test
	public void test1() {
		System.out.println(123);
		log.info(456);
		log.info(rst);
		
	}
}
