package com.model;
   import org.hibernate.SessionFactory;
	//import org.hibernate.boot.Metadata;
	//import org.hibernate.boot.MetadataSources;
	import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.metamodel.Metadata;
	import org.hibernate.metamodel.MetadataSources;
	import org.hibernate.service.ServiceRegistry;


	public class HibernateUtil {	
		
		private static SessionFactory sessionFactory;
		private static SessionFactory buildSessionFactory() {
			try {
				//Create the SessionFactory from hibernate.cfg.xml
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				System.out.println("Hibernate Configration loaded");
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate serviceRegistry created");
				
				SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
	}
			catch(Throwable ex) {
				System.out.println("Initial SessionFactory creation failed."+ex);
				ex.printStackTrace();
				throw new ExceptionInInitializerError(ex);
			}
		}
		public static SessionFactory getSessionFactory(){
			if(sessionFactory == null) sessionFactory = buildSessionFactory();
			return sessionFactory;
		}
	}


