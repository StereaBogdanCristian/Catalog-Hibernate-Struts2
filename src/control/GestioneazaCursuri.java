package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import dbConnection.ReadProfesor;
import dbConnection.ReadWriteCurs;
import model.Curs;
import model.Profesor;

public class GestioneazaCursuri implements SessionAware {
	
	private Curs curs;
	private Profesor profesor;
	private ArrayList<Curs> listaCursuri;
	private ArrayList<Profesor> listaProfesori;
	private String numeCurs;
	private Map<String, Object> sessionMap;
	
	ReadWriteCurs rwc = new ReadWriteCurs();

	public String listaCursuri() {
		this.listaCursuri = rwc.getListaCursuri();
		this.listaProfesori = rwc.getListaProfesori();
		return "success";
	}
	
	public String add() {
		rwc.add(getCurs(), getProfesor());
		ReadProfesor rp = new ReadProfesor();
		Profesor profesor1 = (Profesor) sessionMap.get("profesor");
		Profesor prof = rp.getProfesor(profesor1.getNume());
   		sessionMap.replace("profesor", prof);
		return "success";
		
	}
	
	public String delete() {
		rwc.delete(getNumeCurs());
		System.out.println(getNumeCurs());
		ReadProfesor rp = new ReadProfesor();
		Profesor profesor1 = (Profesor) sessionMap.get("profesor");
		Profesor prof = rp.getProfesor(profesor1.getNume());
   		sessionMap.replace("profesor", prof);
		return "success";
		
	}
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Curs> getListaCursuri() {
		return listaCursuri;
	}

	public void setListaCursuri(ArrayList<Curs> listaCursuri) {
		this.listaCursuri = listaCursuri;
	}


	public String getNumeCurs() {
		return numeCurs;
	}

	public void setNumeCurs(String nume) {
		this.numeCurs = nume;
	}

	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public List<Profesor> getListaProfesori() {
		return listaProfesori;
	}

	public void setListaProfesori(ArrayList<Profesor> listaProfesori) {
		this.listaProfesori = listaProfesori;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}
	
	

}
