package dbConnection;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@WebListener
public class HibernateListener implements ServletContextListener {

    private SessionFactory sessionFactory;
	
    public HibernateListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent e)  { 
    	sessionFactory.close();    
    }

    public void contextInitialized(ServletContextEvent e)  { 
    	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
	    		applySettings(configuration.getProperties()).buildServiceRegistry();
	    
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    
	    e.getServletContext().setAttribute("sessionFactory", sessionFactory);
    }
	
}
