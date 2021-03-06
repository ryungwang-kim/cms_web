package com.cms.app.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cms.app.common.config.Sha256Config;


@Service
public interface LoginService {
	Map<String, Object> selLoginMember(Map<String, Object> param);
	
	int selConnectLog(Map<String, Object> param);
	void insConnectLog(Map<String, Object> param);
	int insConnectLogDetail(Map<String, Object> param);
	void updLogoutLogDetil(Map<String, Object> param);
}
