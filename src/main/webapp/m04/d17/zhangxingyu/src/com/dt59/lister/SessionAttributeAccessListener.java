package com.dt59.lister;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

public class SessionAttributeAccessListener implements HttpSessionAttributeListener{
	Logger logger=Logger.getLogger(SessionAttributeAccessListener.class.getName());
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		 logger.info("-------->���� " + arg0.getName() + " ����ӵ�session�У�������Ϊ "
	                + arg0.getValue().getClass().getName());

	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		  logger.info("-------->���� " + arg0.getName() + " ����session���Ƴ� ");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
		  logger.info("---------------->���� " + arg0.getName() + " ����session �滻��");
	}

}
