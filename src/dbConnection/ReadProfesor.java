package dbConnection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Curs;
import model.Profesor;

public class ReadProfesor {
	
	private Profesor profesor;

	public boolean isParola (String cont, String parola) {
		
		boolean verifica = false;
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    String que = "FROM Profesor WHERE cont= :cont";
	    Query query = session.createQuery(que);
	    query.setParameter("cont", cont);
	    List<?> result = query.list();
		
	    for (Iterator<?> iterator = result.iterator(); iterator.hasNext();) {
			
	    	profesor = (Profesor) iterator.next();
		
	    	if (parola.equals(profesor.getParola())) {
	    		
			verifica = true;
	    	}
	    } 
	    
		session.close();
	    return verifica;
	
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	public Profesor getProfesor(String nume) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    String que = "FROM Profesor WHERE nume= :nume";
	    Query query = session.createQuery(que);
	    query.setParameter("nume", nume);
	    List<?> result = query.list();
		
	    profesor = (Profesor) result.get(0);
	    		
		return profesor;
	}
	
	public ArrayList<Profesor> getListaProfesori() {
		
		ArrayList<Profesor> listaProfesori = new ArrayList<Profesor> ();
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    Query query = session.createQuery("FROM Profesor");
	    List<?> result = query.list();
		
	    for (Iterator<?> iterator = result.iterator(); iterator.hasNext();) {
	    	listaProfesori.add((Profesor) iterator.next());
	    	}
	    return listaProfesori;
	}
	
	public void addProfesor(Profesor profesor) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(profesor);
		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteProfesor(String numeProfesorDelete) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String que = "FROM Profesor WHERE nume= :nume";
	    Query query = session.createQuery(que);
	    query.setParameter("nume", numeProfesorDelete);
	    List<?> result = query.list();
	    profesor = (Profesor) result.get(0);
	    
	    ReadWriteCurs rwc = new ReadWriteCurs();
	    for (Curs curs : profesor.getListaProfesorCurs()) {
			rwc.delete(curs.getNume());
		}
	    
	    session.delete(profesor);
	    
	    session.getTransaction().commit();
		session.close();
	}
}
