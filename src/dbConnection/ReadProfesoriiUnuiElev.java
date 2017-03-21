package dbConnection;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Curs;
import model.Elev;
import model.Profesor;

public class ReadProfesoriiUnuiElev {
	
	public TreeSet<Profesor> getProfesoriiUnuiElev(Elev elev) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		
		String que = "FROM Elev WHERE nume= :elev";
	    Query query = session.createQuery(que);
	    query.setParameter("elev", elev.getNume());
	    List<?> result = query.list();
	    Elev elevR = (Elev)result.get(0);
	    
	    TreeSet<Profesor> listaProfesori = new TreeSet<Profesor>(new Comparator<Profesor>() {
							@Override
							public int compare(Profesor p1, Profesor p2) {
									return p1.getNume().compareToIgnoreCase(p2.getNume());
								}
							}) ;
	    for (Curs curs : elevR.getListaElevCurs()) {
	    	
	    	String hql1 = "from Profesor p join p.listaProfesorCurs c where c.nume= :nume";
	    	Query query1 = session.createQuery(hql1);
		    query1.setParameter("nume", curs.getNume());
	    	
			List<?> list = query1.list();
			
			Object[] row = (Object[]) list.get(0);
			Profesor prof = (Profesor)row[0];
				
			listaProfesori.add(prof);
			
	    }
	    session.close();
		return listaProfesori;
	}

}
