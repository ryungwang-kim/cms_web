package com.cms.app.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.app.common.repository.MenuRepository;
import com.cms.app.common.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Map<String, Object>> selMainMenu() {
		return menuRepository.selMainMenu();
	}

	@Override
	public List<Map<String, Object>> selMdMenu() {
		return menuRepository.selMdMenu();
	}

	@Override
	public List<Map<String, Object>> selSmMenu() {
		return menuRepository.selSmMenu();
	}

}
	
	