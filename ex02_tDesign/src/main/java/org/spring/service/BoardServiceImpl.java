package org.spring.service;

import java.util.List;

import org.spring.domain.BoardVO;
import org.spring.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
//	@Autowired
//	private BoardMapper mapper;
	
	//의존성 주입
	private final BoardMapper mapper;
	
	@Override
	public List<BoardVO> listAll() {
		log.info("listAll()");
		return mapper.selectAll();
	}

	@Override
	public void register(BoardVO vo) {
		log.info("vo: "+vo);
		mapper.insert(vo);	}
	
	@Override
	public Integer registerKey(BoardVO vo) {
		log.info("vo: "+vo);
		mapper.insertSelectBno(vo);
		return vo.getBno();
	}

	@Override
	public int modify(BoardVO vo) {
		log.info("modify");
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		log.info("remove");
		return mapper.delete(key);
	}
	
	@Override
	public BoardVO get(Integer key) {
		log.info("get");
		return mapper.select(key);
	}
	
//	@Override
//	public int getMax() {
//		log.info("Max");
//		return mapper.getMaxBno();
//	}
	



}
