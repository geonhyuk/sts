package org.spring.service;

public interface GenericService<VO, K> {
	
	// PK로 특정 튜플 반환
	public VO get(K key);
	// 릴레이션에 튜블 추가
	public void register(VO vo);
	// 튜플 수정 * 스프링에서는  파라미터타입을 객체로 설정하는것이 좋다
	public int modify(VO vo);
	// 튜플 삭제
	public int remove(K key);
	
}
