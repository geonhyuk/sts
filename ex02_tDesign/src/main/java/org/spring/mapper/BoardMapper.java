package org.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.spring.domain.BoardVO;

public interface BoardMapper {
	// CRUD
	public void insert(BoardVO vo);
	
	public void insertSelectBno(BoardVO vo);
	
//	@Select("select * from tbl_board")
	public List<BoardVO> selectAll();
	
	public int update(BoardVO vo);
	
//	@Delete("delete from tbl_board where bno=#{bno}")
	public int delete(int bno);
	
	// 글 상세보기
	public BoardVO select(Integer key);
	
	// 다음번째 bno 찾기
//	public Integer getMaxBno();
	
}
