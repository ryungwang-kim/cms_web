package com.cms.app.board.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.app.board.dao.AbstractDAO;

@Repository
public class BoardRepository extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getBoardList() {
		
		return selectList("getBoardList");
	}     

	public void boardIns(Map<String, Object> parameter) {
		
		System.out.println(parameter);
		insert("board.insertboard", parameter);
	}
	
	public void update(Map<String, Object> parameter) {
		
		System.out.println(parameter);
		update("bid", parameter);
	}


	public int delete(Map<String,Object>parameter) {
		
		return (int) selectOne("delete",parameter);
	}
}
