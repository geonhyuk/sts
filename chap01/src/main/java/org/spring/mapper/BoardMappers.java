package org.spring.mapper;

import java.util.List;

import org.spring.domain.VO;

public interface BoardMappers {

	public void insert(VO vo);
	
	public List<VO> selectAll();
	
	public int update(VO vo);
	
	public int delete(int bno);
}
