package com.cms.app.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface MenuService {
	
	List<Map<String, Object>> selMainMenu();
	List<Map<String, Object>> selMdMenu();
	List<Map<String, Object>> selSmMenu();
}
