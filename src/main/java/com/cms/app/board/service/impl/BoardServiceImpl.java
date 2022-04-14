package com.cms.app.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.app.board.repository.BoardRepository;
import com.cms.app.board.service.BoardService;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;

	// 리스트 형태의 파라미터 값이 없는 부분
	// id에대한 select문을 실행하면서 조건(쿼리문에서 사용할 인자)을 전달한다
	@Override
	public List<Map<String, Object>> getBoardList() {
		return boardRepository.getBoardList();
	}
 
	
	@Override
	public void boardIns(Map<String, Object> map) {
		boardRepository.boardIns(map);
	}

	@Override
	public void update(Map<String, Object> map) {
		boardRepository.update(map);
	}

	@Override
	public int delete(Map<String,Object>map) {
		
		return boardRepository.delete(map);
	}
	
}
