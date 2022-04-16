package com.cms.app.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.app.common.repository.LoginRepository;
import com.cms.app.common.repository.MenuRepository;
import com.cms.app.common.service.LoginService;
import com.cms.app.common.service.MenuService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Map<String, Object> selLoginMember(Map<String, Object> param) {
		return loginRepository.selLoginMember(param);
	}

	@Override
	public int insConnectLog(Map<String, Object> param) {
		return loginRepository.insConnectLog(param);
	}

	@Override
	public void updLogoutLog(Map<String, Object> param) {
		loginRepository.updConnectLog(param);
	}

}
	
	