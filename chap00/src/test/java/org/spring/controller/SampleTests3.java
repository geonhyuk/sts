package org.spring.controller;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mapper.Mapper;
import org.spring.model.VO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//테스트 코드가 스프링을 실행하는 역할이라고 표시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/data.xml"})
@Log4j // Lombok을 이용해서 로그 기록하는 객체 생성
public class SampleTests3 {
	@Inject//개발자가 객체 생성을 하는 것이 아닌 스프링이 객체 생성을 하게 만듦.
	private SqlSessionFactory ssf;
	
	@Inject
	private Mapper map;
	
	@Test
	public void testFactory() {
		log.info(ssf);	
		
	}
	
	@Test
	public void testSession() {
		try (SqlSession session = ssf.openSession()) {
			List<VO> list = map.getAllMembers();
			
			System.out.println(list);
			VO param = new VO();
			param.setId("a");
			param.setPwd("b");
			
			VO result = map.getMembers(param);
			
			System.out.println(result.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
