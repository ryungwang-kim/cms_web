package com.cms.app.member.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cms.app.board.dao.AbstractDAO;

@Repository
public class MemberRepository extends AbstractDAO{
	
	public List<Map<String, Object>> selMemberAll(){
		return selectList("selMemberAll");
	}
}