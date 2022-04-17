package com.cms.app.common.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.app.common.repository.LoginRepository;
import com.cms.app.common.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Map<String, Object> selLoginMember(Map<String, Object> param) {
		return loginRepository.selLoginMember(param);
	}
	
	@Override
	public int selConnectLog(Map<String, Object> param) {
		return loginRepository.selConnectLog(param);
	}

	@Override
	public void insConnectLog(Map<String, Object> param) {
		loginRepository.insConnectLog(param);
	}

	@Override
	public int insConnectLogDetail(Map<String, Object> param) {
		return loginRepository.insConnectLogDetail(param);
	}

	@Override 
	public void updLogoutLogDetil(Map<String, Object> param) {
		loginRepository.updLogoutLogDetil(param); 
	}


}
	
	