package dbConnection;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Curs;
import model.Profesor;

public class ReadWriteCurs {

	private ArrayList<Curs> listaCursuri = new ArrayList<Curs>();
	private ArrayList<Profesor> listaProfesori = new ArrayList<Profesor>();
	
	public ArrayList<Curs> getListaCursuri() {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    Query query = session.createQuery("FROM Curs C ORDER BY C.nume ASC");
	    List<?> result = query.list();
	    
	    for (Object curs : result) {
			listaCursuri.add((Curs)curs);
		}
		session.close();
	    return listaCursuri;
	}
	
	public ArrayList<Profesor> getListaProfesori() {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
	    
	    Query query = session.createQuery("FROM Profesor P ORDER BY P.nume ASC");
	    List<?> result = query.list();
	    
	    for (Object profesor : result) {
			listaProfesori.add((Profesor)profesor);
		}
		session.close();
	    return listaProfesori;
	}

	public void add(Curs curs, Profesor profesor) {
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(curs);
		
		String que = "FROM Profesor WHERE nume= :profesor";
	    Query query = session.createQuery(que);
	    query.setParameter("profesor", profesor.getNume());
	    List<?> result = query.list();
	    Profesor profesorX = (Profesor)result.get(0);
	    profesorX.getListaProfesorCurs().add(curs);
		session.update(profesorX);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(String numeCurs) {
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println(numeCurs);
		
		String que = "from Profesor p join p.listaProfesorCurs c where c.nume= :nume";
	    Query query = session.createQuery(que);
	    query.setParameter("nume", numeCurs);
	    List<?> result = query.list();
	    
		Object[] row = (Object[]) result.get(0);
		Profesor profesor = (Profesor)row[0];
	  
		
		String que1 = "FROM Curs WHERE nume= :nume";
	    Query query1 = session.createQuery(que1);
	    query1.setParameter("nume", numeCurs);
	    List<?> list1 = query1.list();
	    Curs curs = (Curs) list1.get(0);
	    
	
	    profesor.getListaProfesorCurs().remove(curs);
	    session.delete(curs);
	    
	    session.getTransaction().commit();
		session.close();
	}
	
	
	
}
