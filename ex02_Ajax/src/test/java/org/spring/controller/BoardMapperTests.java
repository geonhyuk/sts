package org.spring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.domain.BoardVO;
import org.spring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(1);
		log.info("삭제된 행의 갯수 : "+ count);
	}
	
	@Test
	public void testSelect() {
		BoardVO vo = boardMapper.select(8);
		log.info(vo);
	}
}
