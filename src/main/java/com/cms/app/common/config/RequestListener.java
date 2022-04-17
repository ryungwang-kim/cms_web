package com.cms.app.common.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public RequestListener() {
    	System.out.println("ServletRequestListener 생성자 실행");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("ServletRequestListener 파괴 실행");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	//System.out.println("ServletRequest에 속성 삭제 - 속성명 : " + srae.getName() + ", 속성 값 : " + srae.getValue());
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("!!!요청정보 생성!!!");
        
        ServletContext ctx = sre.getServletContext();
        HttpServletRequest request =  (HttpServletRequest)sre.getServletRequest();
        
        System.out.println(ctx.getServerInfo());
        //ServletRequestListener 리스너에서는 요청 파라미터를 얻을 수 있습니다.
        System.out.println("url : " + request.getRequestURL());
        System.out.println("uri : " + request.getRequestURI());

    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	//System.out.println("ServletRequest에 속성 추가 - 속성명 : " + srae.getName() + ", 속성 값 : " + srae.getValue());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	//System.out.println("ServletRequest에 속성 변경 - 속성명 : " + srae.getName() + ", 속성 값 : " + srae.getValue());
    }
	
}
