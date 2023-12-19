package org.spring.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.spring.domain.BoardVO;

public interface BoardMapper {
	// CRUD
	public void insert(BoardVO vo);
	
	public void insertSelectBno(BoardVO vo);
	
//	@Select("SELECT * FROM tbl_board")
	public List<BoardVO> selectAll();
	
	public int update(BoardVO vo);
	
	public int delete(int bno);
	
	public BoardVO select(int bno);
	
	//public int getMaxbno();
}
