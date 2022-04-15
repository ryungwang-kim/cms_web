package com.cms.app;

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

import com.cms.app.common.config.Sha256Config;
import com.cms.app.common.service.LoginService;
import com.cms.app.common.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	@Autowired
	private MenuService menuService;

	@Autowired
	private LoginService loginService;
	
	// 인덱스 경로
	@RequestMapping(value = "/index.do")
	public String main(HttpServletRequest request, Model model) {
		List<Map<String, Object>> mainMenu = menuService.selMainMenu();
		List<Map<String, Object>> mdMenu = menuService.selMdMenu();
		List<Map<String, Object>> smMenu = menuService.selSmMenu();
		
		model.addAttribute("mainMenu", mainMenu);
		model.addAttribute("mdMenu", mdMenu);
		model.addAttribute("smMenu", smMenu);
		
		return "index";
	}
	
	@RequestMapping(value="/user/join.do" , method = RequestMethod.GET)
	public String join(HttpSession join) {
		
		return "/user/join";
    }
	
	@RequestMapping(value= "/user/login.do", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
				
		return "/user/login"; // 파일경로
	}
	
	@ResponseBody
	@RequestMapping(value="/user/loginAction.do")
	public Map<String,Object> loginsel(@RequestParam Map<String, Object> param, HttpSession session, HttpServletRequest request) throws Exception {
		Map<String, Object> loginMap = loginService.selLoginMember(param);
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
		
		if(chk == true) {
			Map<String, Object> djConnectMap = new HashMap<String, Object>();
			djConnectMap.put("memId", loginMap.get("mem_id"));
			djConnectMap.put("ip", request.getRemoteAddr());
			djConnectMap.put("logType", "login");
			
			session.setAttribute("memId", loginMap.get("mem_Id"));
			session.setAttribute("logNo", loginService.insConnectLog(djConnectMap));
		}
		
		resultMap.put("check", chk);
		resultMap.put("message", message);
		
		return resultMap;
    }
	@RequestMapping("/user/logout.do")
	public String logout(HttpSession session) {
		
		loginService.updLogoutLog(Integer.parseInt(session.getAttribute("logNo").toString()));
		session.invalidate();
		
		return "redirect:/index.do";
	}
	
	//비밀번호 체크
	public String checkPassword(Map<String, Object> param) throws Exception {
		// sha256 암호비교
		Sha256Config sha256Config = new Sha256Config();
		String pwCheck = sha256Config.SHA256Encrypt(param.get("memPw").toString());
		
		return pwCheck;
	}
}
