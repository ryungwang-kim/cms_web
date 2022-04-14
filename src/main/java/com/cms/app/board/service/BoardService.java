package com.cms.app.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	
	List<Map<String, Object>> getBoardList();

	void boardIns(Map<String, Object> map);

	void update(Map<String, Object> map);

	int delete(Map<String, Object>map);

	}
