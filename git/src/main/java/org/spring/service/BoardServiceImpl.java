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
public class BoardServiceImpl implements BoardService {
//	@Autowired
//	private BoardMapper mapper;
	
	private final BoardMapper mapper;
	
	
	@Override
	public List<BoardVO> listAll() {		
		log.info("listAll()");
		return mapper.selectAll();
	}	

	@Override
	public void register(BoardVO vo) {
		log.info("vo: "+vo);
//		mapper.insert(vo);
		mapper.insertSelectBno(vo);
	}

	@Override
	public int modify(BoardVO vo) {		
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		log.info("remove");
		
		return mapper.delete(key);
	}
	
	@Override
	public BoardVO get(Integer key) {
		return mapper.select(key);
	}

//	@Override
//	public int getMaxbno() {
//		
//		return mapper.getMaxbno();
//	}

	
}
