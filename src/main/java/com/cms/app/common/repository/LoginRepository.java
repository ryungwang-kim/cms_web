package com.cms.app.common.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.app.board.dao.AbstractDAO;

@Repository
public class LoginRepository extends AbstractDAO{
	
	public Map<String, Object> selLoginMember(Map<String, Object> param){
		return (Map<String, Object>) selectOne("common.selLoginMember", param);
	}
	
	public int selConnectLog(Map<String, Object> param) {
		return (int) selectOne("common.selConnectLog", param);
	}
	
	public void insConnectLog(Map<String, Object> param){
		insert("common.insConnectLog", param);
	}
	
	public int insConnectLogDetail(Map<String, Object> param){
		insert("common.insConnectLogDetail", param);
		return (int) selectOne("common.selConnectDetailNowLog");
	}
	
	public void updLogoutLogDetil(Map<String, Object> param){
		update("common.updLogoutLogDetil", param); 
	}
	
}