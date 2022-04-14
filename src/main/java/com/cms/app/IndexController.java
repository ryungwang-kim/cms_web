package com.cms.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.app.common.service.MenuService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	@Autowired
	private MenuService menuService;
	
	// 인덱스 경로
	@RequestMapping(value = "/index.do")
	public String main(Model model) {
		
		List<Map<String, Object>> mainMenu = menuService.selMainMenu();
		List<Map<String, Object>> mdMenu = menuService.selMdMenu();
		List<Map<String, Object>> smMenu = menuService.selSmMenu();
		
		model.addAttribute("mainMenu", mainMenu);
		model.addAttribute("mdMenu", mdMenu);
		model.addAttribute("smMenu", smMenu);
		
		return "index";
	}

	
}
