package dbConnection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Curs;
import model.Elev;

public class ReadElev {
	
	private Elev elev;
	private ArrayList<Elev> listaElevi = new ArrayList<Elev>();
	
	public boolean isParola (String cont, String parola) {
		
		boolean verifica = false;
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    String que = "FROM Elev WHERE cont= :cont";
	    Query query = session.createQuery(que);
	    query.setParameter("cont", cont);
	    List<?> result = query.list();
		
	    for (Iterator<?> iterator = result.iterator(); iterator.hasNext();) {
			
	    	elev = (Elev) iterator.next();
		
	    	if (parola.equals(elev.getParola())) {
	    		
			verifica = true;
	    	}
	    } 
	    
		session.close();
	    return verifica;
	
	}
	
	public Elev getElev() {
		return elev;
	}
	
	public Elev getElev(String numeElev) {
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    String que = "FROM Elev WHERE nume= :nume";
	    Query query = session.createQuery(que);
	    query.setParameter("nume", numeElev);
	    List<?> result = query.list();
	    
	    return (Elev) result.get(0);
	}
	
	
	public ArrayList<Elev> getListaElevi() {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    Query query = session.createQuery("FROM Elev");
	    List<?> result = query.list();
		
	    for (Iterator<?> iterator = result.iterator(); iterator.hasNext();) {
	    	listaElevi.add((Elev) iterator.next());
	    	}
	    return listaElevi;
	}
	
	
	public void add(Elev elev, ArrayList<String> listaElevCursuri) {
		
		for (String string : listaElevCursuri) {
			System.out.println(string);
		}
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
	    for (String c : listaElevCursuri) {
	    	String que1 = "FROM Curs WHERE nume= :curs";
		    Query query1 = session.createQuery(que1);
		    query1.setParameter("curs", c);
		    List<?> result1 = query1.list();
		    Curs cursX = (Curs)result1.get(0);
		    elev.getListaElevCurs().add(cursX);
		}
	   
		session.save(elev);
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	public void deleteElev(String numeElevDelete) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String que = "DELETE FROM Elev WHERE nume= :nume";
	    Query query = session.createQuery(que);
	    query.setParameter("nume", numeElevDelete);
	    query.executeUpdate();
	    
	    session.getTransaction().commit();
		session.close();	   
	}
	
	
	public HashSet<Elev> getListaCursElevi(String numeCursAles) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
	    String que = "from Elev e join e.listaElevCurs c where c.nume= :nume";
		Query query = session.createQuery(que);
		query.setParameter("nume", numeCursAles);
		List<?> result = query.list();
		    
		HashSet<Elev> listaCursElevi = new HashSet<Elev>();
		    
		for (int i = 0; i < result.size(); i++) {
			Object[] ls = (Object[]) result.get(i);
			Elev el =(Elev) ls[0];
			listaCursElevi.add(el);
		}
		
		session.getTransaction().commit();
		session.close();
		
		return listaCursElevi;
	}
	
	
	public void addNota(String numeElev, String numeCurs, int nota){
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    
	    String que = "FROM Elev WHERE nume= :nume";
	    Query query = session.createQuery(que);
	    query.setParameter("nume", numeElev);
	    List<?> result = query.list();
	    
	    Elev elev = (Elev) result.get(0);
	   
	    System.out.println(elev.getNume() + "  " + numeCurs + "  " + nota);
	    
	    elev.getListaNote().put(numeCurs, nota);
	    
	    session.update(elev);
		session.getTransaction().commit();
		session.close();
		
	}
}
