package com.dt59.lister;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

public class SessionAttributeAccessListener implements HttpSessionAttributeListener{
	Logger logger=Logger.getLogger(SessionAttributeAccessListener.class.getName());
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		 logger.info("-------->变量 " + arg0.getName() + " 被添加到session中，其类型为 "
	                + arg0.getValue().getClass().getName());

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		  logger.info("-------->变量 " + arg0.getName() + " 被从session中移除 ");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
		  logger.info("---------------->变量 " + arg0.getName() + " 被从session 替换！");
	}

}
