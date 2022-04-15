package com.cms.app.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.app.common.config.SessionConfig;
import com.cms.app.common.config.Sha256Config;
import com.cms.app.member.service.MemberService;

@Controller
@RequestMapping("/member") // URL 경로
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/memberList.do" , method = RequestMethod.GET)
	public String memberList(HttpSession join_, Model model) {
		List<Map<String, Object>> memberList = memberService.selMemberAll();
		
		System.out.println(memberList.toString());
		
		model.addAttribute("list", memberList);
		
		return "/member/memberList";
    }
}
