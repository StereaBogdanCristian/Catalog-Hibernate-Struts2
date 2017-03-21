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

public class ReadEleviiUnuiProfesor {

	public TreeSet<Elev> getEleviiUnuiProfesor(Profesor profesor) {
		
		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
		Session session = sessionFactory.openSession();
		
		String que = "FROM Profesor WHERE nume= :profesor";
	    Query query = session.createQuery(que);
	    query.setParameter("profesor", profesor.getNume());
	    List<?> result = query.list();
	    Profesor profesorR = (Profesor)result.get(0);
	    TreeSet<Elev> listaElevi = new TreeSet<Elev>(new Comparator<Elev>() {
						@Override
						public int compare(Elev e1, Elev e2) {
							return e1.getNume().compareToIgnoreCase(e2.getNume());
						}
					}) ;
	    
	    for (Curs curs : profesorR.getListaProfesorCurs()) {
	    
			String hql1 = "from Elev el join el.listaElevCurs c where c.nume= :curs";
	   
			Query query1 = session.createQuery(hql1);
			query1.setParameter("curs", curs.getNume());
			List<?> list1 = query1.list();
		
		
			for(int i=0; i<list1.size(); i++) {
				Object[] row = (Object[]) list1.get(i);
				Elev elev1 = (Elev)row[0];
				listaElevi.add(elev1);
			}
	    }
	    
	    return listaElevi;
	}
	
}
