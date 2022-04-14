package com.cms.app.member.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.app.board.dao.AbstractDAO;

@Repository
public class MemberRepository extends AbstractDAO{
	

	public void joinIns(Map<String, Object> parameter) {
		insert("insertmember", parameter);
		
	}
	
	public int loginch(Map<String,Object>parameter) {
		
		return (int) selectOne("selectlogin",parameter);
	}

	public List<Map<String, Object>> selMemberAll(){
		return selectList("selMemberAll");
	}
	
	public Map<String, Object> selLoginMember(Map<String, Object> param){
		return (Map<String, Object>) selectOne("selLoginMember", param);
	}
}