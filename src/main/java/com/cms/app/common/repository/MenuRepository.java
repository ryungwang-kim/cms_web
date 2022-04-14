package com.cms.app.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.app.board.dao.AbstractDAO;

@Repository
public class MenuRepository extends AbstractDAO{
	

	public List<Map<String, Object>> selMainMenu() {
		return selectList("selMainMenu");
	}
	
	public List<Map<String, Object>> selMdMenu() {
		return selectList("selMdMenu");
	}
	
	public List<Map<String, Object>> selSmMenu() {
		return selectList("selSmMenu");
	}
}