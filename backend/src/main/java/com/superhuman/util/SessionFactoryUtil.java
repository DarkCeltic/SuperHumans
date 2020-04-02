package com.superhuman.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;
	private static SessionFactoryUtil sessionFactoryUtil;

	private static final String USERNAME = System.getenv("POSTGRES_USERNAME");
	private static final String PASSWORD = System.getenv("POSTGRES_PASSWORD");
	private static final String URL = "jdbc:postgresql://" + System.getenv("POSTGRES_URL") + ":5432/SuperHeroes?";
	private static String schema = "public";

	public static SessionFactoryUtil getSessionFactoryUtil() {
		if (sessionFactoryUtil == null) {
			sessionFactoryUtil = new SessionFactoryUtil();
		}
		return sessionFactoryUtil;
	}

	private SessionFactoryUtil() {
		if (sessionFactory == null) {
			System.out.println(USERNAME);
			System.out.println(PASSWORD);
			System.out.println(URL);
			Map<String, String> settings = new HashMap<String, String>();
			settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.default_schema", schema);
			settings.put("show_sql", "true");
			settings.put("connection.pool_size", "1");
			settings.put("hibernate.connection.url", URL);
			settings.put("hibernate.connection.username", USERNAME);
			settings.put("hibernate.connection.password", PASSWORD);

			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings)
					.build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.addAnnotatedClass(com.superhuman.entity.SuperHuman.class)
					.addAnnotatedClass(com.superhuman.entity.SuperHumanTeams.class).getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public static void setConfigFileLocationToTest() {
		schema = "publictest";
	}
}
