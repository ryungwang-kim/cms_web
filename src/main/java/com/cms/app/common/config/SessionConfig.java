package com.cms.app.common.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class SessionConfig implements HttpSessionListener {

	private static Logger logger = LoggerFactory.getLogger(SessionConfig.class);
	  
	//  총 접속자 수
	public static int sessionUserCounter;
	  
	public static int getCount() {
		return sessionUserCounter;
	}
	
    private static final Map<String, HttpSession> sessions = new ConcurrentHashMap<>();

    public synchronized static void getSessionCheck(String type, String id){
        String result = "";
        for (String key : sessions.keySet()){
            HttpSession hs = sessions.get(key);
            if(hs != null && hs.getAttribute(type) != null && hs.getAttribute(type).toString().equals(id)){
                result = key.toString();
            }
        }

        removeSessionForDoubleLogin(result);

    }

    private static void removeSessionForDoubleLogin(String memId){
        if(memId != null && memId.length() > 0){
            sessions.get(memId).invalidate();
            sessions.remove(memId);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    	HttpSession session = se.getSession();
    	sessionUserCounter ++;
	    logger.error("\n\tSESSION CREATED : {}, TOTAL ACCESSER : {}", session.getId(), sessionUserCounter);
	    
        sessions.put(se.getSession().getId(), se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	// 세션이 소멸될 때
    	sessionUserCounter--;
    	if( sessionUserCounter < 0 ) sessionUserCounter = 0;
    	HttpSession session = se.getSession();
    	logger.error("\n\tSESSION DESTROYED : {}, TOTAL ACCESSER : {}", session.getId(), sessionUserCounter);
        
        if(sessions.get(se.getSession().getId()) != null){
            sessions.get(se.getSession().getId()).invalidate();
            sessions.remove(se.getSession().getId());
        }
    }
}
