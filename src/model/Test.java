package model;

import org.apache.struts2.ServletActionContext;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Test {

	public void hibernate() {

		SessionFactory sessionFactory = 
				(SessionFactory) ServletActionContext.getServletContext().getAttribute("sessionFactory");
				
		
		Session session = sessionFactory.openSession();
	    
	    Transaction transaction = session.beginTransaction();
	    
	    Curs curs1 = new Curs();
	    curs1.setNume("C1");
	    Curs curs2 = new Curs();
	    curs2.setNume("C2");
	    Curs curs3 = new Curs();
	    curs3.setNume("C3");
	    
	    Elev elev1 = new Elev();
	    elev1.setNume("E1");
	    elev1.setCont("1");
	    elev1.setParola("1");
	    Elev elev2 = new Elev();
	    elev2.setNume("E2");
	    elev2.setCont("2");
	    elev2.setParola("2");

	    Elev elev3 = new Elev();
	    elev3.setNume("E3");
	    elev3.setCont("3");
	    elev3.setParola("3");

	    
	    Profesor profesor1 = new Profesor();
	    profesor1.setNume("P1");
	    profesor1.setCont("P1");
	    profesor1.setParola("1");
	    Profesor profesor2 = new Profesor();
	    profesor2.setNume("P2");
	    profesor2.setCont("P2");
	    profesor2.setParola("2");
	   
	    
	    elev1.getListaElevCurs().add(curs1);
	    elev1.getListaElevCurs().add(curs2);
	    
	    elev2.getListaElevCurs().add(curs2);
	    elev2.getListaElevCurs().add(curs3);
	    
	    elev3.getListaElevCurs().add(curs1);
	   
	    profesor1.getListaProfesorCurs().add(curs1);
	    profesor1.getListaProfesorCurs().add(curs2);
	    
	    profesor2.getListaProfesorCurs().add(curs3);
	    
	    elev1.getListaNote().put(curs1.getNume(), 5);
	    
	    elev1.getListaNote().put(curs2.getNume(), 7);
	    
	    
	    elev2.getListaNote().put(curs2.getNume(), 8);

	    elev2.getListaNote().put(curs3.getNume(), 6);
	    
	    elev3.getListaNote().put(curs1.getNume(), 9);
	    
	    
	    session.save(elev1);
	    session.save(elev2);
	    session.save(elev3);
	    
	    session.save(profesor1);
	    session.save(profesor2);
	    
	    session.save(curs1);
	    session.save(curs2);
	    session.save(curs3);
	    
	    
	    // Adaugare elev, participa la cursul 3 *********************************************
	    
	    Elev el = new Elev();
	    el.setNume("E4");
	    el.setCont("4");
	    el.setParola("4");

	    session.save(el);
	    
	    el.getListaElevCurs().add(curs3);
	    
	    /*
	    // Citire note elev  ****************************************************
	   
	    
	    String que = "FROM Elev WHERE nume= :elev";
	    Query query = session.createQuery(que);
	    query.setParameter("elev", "E4");
	    List<?> result = query.list();
	    
	    Elev elevA = (Elev)result.get(0);
	    
	    elevA.afiseazaNote();
	    
	    
	    //**********************************************************************************
	    
	    // Cursurile la care participa un elev
	    
	    String que1 = "FROM Elev WHERE nume= :elev";
	    Query query1 = session.createQuery(que1);
	    query1.setParameter("elev", "E1");
	    List<?> result1 = query1.list();
	    Elev elevA1 = (Elev)result1.get(0);
	    
	    System.out.println("Cursurile la care participa un elev");
	    elevA1.afiseazaCursuri();
	   
	    //**********************************************************************************
	    
	    // Cursurile pe care le preda un profesor
	    
	    String que2 = "FROM Profesor WHERE nume= :profesor";
	    Query query2 = session.createQuery(que2);
	    query2.setParameter("profesor", "P1");
	    List<?> result2 = query2.list();
	    Profesor profesorX2 = (Profesor)result2.get(0);
	    System.out.println("Cursurile pe care le preda fiecare profesor");
	    profesorX2.afiseazaCursuri();
	    
	    //**********************************************************************************
	    
	    // Profesorii unui elev
	    
	    String que3 = "FROM Elev WHERE nume= :elev";
	    Query query3 = session.createQuery(que3);
	    query3.setParameter("elev", "E2");
	    List<?> result3 = query3.list();
	    Elev elevA3 = (Elev)result3.get(0);
	    
	    HashSet<String> listaProfesori = new HashSet<String>();
	    
	    for (Curs curs : elevA3.getListaElevCurs()) {
	    	
	    	
	    	String hql = "from Profesor p join p.listaProfesorCurs c where c.nume= :nume";
	    	Query query4 = session.createQuery(hql);
		    query4.setParameter("nume", curs.getNume());
	    	
			List<?> list = query4.list();
			
			Object[] row = (Object[]) list.get(0);
			Profesor prof = (Profesor)row[0];
				
			listaProfesori.add(prof.getNume());
			
	    }
	    System.out.println("Profesorii unui elev");
			
	    for (String profe : listaProfesori) {
				System.out.println(profe);
		}
	    
	    //**********************************************************************************
	    
	    // Elevii unui profesor
	   
	    String que12 = "FROM Profesor WHERE nume= :profesor";
	    Query query12 = session.createQuery(que12);
	    query12.setParameter("profesor", "P2");
	    List<?> result12 = query12.list();
	    Profesor profesorX12 = (Profesor)result12.get(0);
	    HashSet<String> listaElevi = new HashSet<String>();
	    
	    for (Curs curs : profesorX12.getListaProfesorCurs()) {
	    
			String hql11 = "from Elev el join el.listaElevCurs c where c.nume= :curs";
	   
			Query query11 = session.createQuery(hql11);
			query11.setParameter("curs", curs.getNume());
			List<?> list11 = query11.list();
		
		
			for(int i=0; i<list11.size(); i++) {
				Object[] row = (Object[]) list11.get(i);
				Elev elev11 = (Elev)row[0];
				listaElevi.add(elev11.getNume());
			}
	    }
	   System.out.println("Lista elevilor unui profesor: ");
	    for (String elev : listaElevi) {
			System.out.println(elev);
		}
	   
	    */
	    transaction.commit();
	    session.close();
	    
	    
	    
	}

}

