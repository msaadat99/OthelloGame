package org.othello.hibernate;



import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

		
		private static  SessionFactory sessionFactory = null;
		private static Logger log = Logger.getLogger("HibernateUtil"); 
		//private static final  StandardServiceRegistryBuilder serviceRegistry;
		
		static {
			
			// A SessionFactory is set up once for an application!
			 StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			 
			 log.info("BBBBBBBBBBB");
			try {
				
				log.info("XXXXFFFFF");
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
				log.info("Session Factory Created ... "+ sessionFactory);
			}
			catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				StandardServiceRegistryBuilder.destroy( registry );
				log.error("HibernateUtil: Error: "+ e);
			}
		}
		
		public static SessionFactory getSessionFactory() {
			log.info("Before creating session factory ...");
			return sessionFactory;
		}
	}


