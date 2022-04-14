package com.cms.app.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value="/join_" , method = RequestMethod.GET)
	public String join(HttpSession join_) {
		
		return "/member/join_";
    }
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
				
		return "/member/login"; // 파일경로
	}
	
	@ResponseBody
	@RequestMapping(value="/loginAction")
	public Map<String,Object> loginsel(@RequestParam Map<String, Object> param, HttpSession session) throws Exception {
		Map<String, Object> loginMap = memberService.selLoginMember(param);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boolean chk = true;
		
		String message = "";
		String passWordCheck = checkPassword(param);
		if(loginMap == null) {
			 chk = false;
			 message = "사용자 정보가 없습니다.";
			 
		}else if(!passWordCheck.equals(loginMap.get("mem_pw"))){
            chk = false;
            message = "비밀번호가 일치하지 않습니다.";
        }
		
		resultMap.put("check", chk);
		resultMap.put("message", message);
		
		return resultMap;
    }
	
	//비밀번호 체크
	public String checkPassword(Map<String, Object> param) throws Exception {
		// sha256 암호비교
		Sha256Config sha256Config = new Sha256Config();
		
		String pwCheck = sha256Config.SHA256Encrypt(param.get("memPw").toString());
		
		return pwCheck;
	}
}
