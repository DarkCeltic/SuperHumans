package com.superhuman.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.superhuman.util.SessionFactoryUtil;

public class AppConfig {
	@Autowired
	private ApplicationContext context;

	@Bean
	public SessionFactory sessionFactory() {
		return SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
	}
}
