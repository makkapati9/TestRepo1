package com.avd.common.util;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext ctx;

	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		ctx = appContext;

	}
//Manish
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
}