package com.cms.app.member.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public interface MemberService {
	
	List<Map<String, Object>> selMemberAll();
}
