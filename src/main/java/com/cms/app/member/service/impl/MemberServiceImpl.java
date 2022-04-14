package com.cms.app.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.app.member.repository.MemberRepository;
import com.cms.app.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Map<String, Object>> selMemberAll() {
		return memberRepository.selMemberAll();
	}

	@Override
	public Map<String, Object> selLoginMember(Map<String, Object> param) {
		return memberRepository.selLoginMember(param);
	}

}
	
	
	