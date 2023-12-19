package org.spring.service;

import java.util.List;

import org.spring.domain.BoardVO;

public interface BoardService extends GenericService<BoardVO, Integer>  {
	// 전체 글 보기
	public List<BoardVO> listAll();
	
	public Integer registerKey(BoardVO vo);
	
	// 현재 테이블의 bno 최대값 반환
//	public int getMax();
}
