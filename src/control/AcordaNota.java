package control;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dbConnection.ReadElev;
import model.Curs;
import model.Elev;
import model.Profesor;

public class AcordaNota extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	
	private Profesor profesor;
	private String numeCursAles;

	private Set<Curs> listaCursuriProfesor = new HashSet<Curs>();
	private Set<Elev> listaCursElevi = new HashSet<Elev>();
	private Map<String, Integer> eleviListaNote = new TreeMap<String, Integer>();
	private String elevNotaAcordata;
	private String elevNotaNume;
	private String numeElevAles;
	private Elev elevModifica;
	private Map<String, Object> sessionMap;
	
	public String afiseazaCursuri() {
		
		profesor = (Profesor) ActionContext.getContext().getSession().get("profesor");
		for (Curs curs : profesor.getListaProfesorCurs()) {
			listaCursuriProfesor.add(curs);
		}
		return "success";
	}
	
	public String afiseazaEleviCurs() {
		
		profesor = (Profesor) ActionContext.getContext().getSession().get("profesor");
		ReadElev re = new ReadElev();
		if (getNumeCursAles() == null) {
			numeCursAles = (String) sessionMap.get("numeCursAles");
		} else {
		sessionMap.put("numeCursAles", getNumeCursAles());
		}
		listaCursElevi = re.getListaCursElevi(getNumeCursAles());
		eleviListaNote.clear();
		for (Elev elev : listaCursElevi) {	
				eleviListaNote.put(elev.getNume(), elev.getListaNote().get(numeCursAles));
		}
		
		return "success";
	}
	
	public String eleviListaNoteModifica() {
		
		numeCursAles = (String) sessionMap.get("numeCursAles");
		ReadElev re = new ReadElev();
		elevModifica = re.getElev(getNumeElevAles());
		
		return "success";
	}
	
	public String addNota() {
		
		ReadElev re = new ReadElev();
		re.addNota(getElevNotaNume(), (String)sessionMap.get("numeCursAles"), Integer.parseInt(getElevNotaAcordata()));
		return "success";
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public String getNumeCursAles() {
		return numeCursAles;
	}

	public void setNumeCursAles(String numeCursAles) {
		this.numeCursAles = numeCursAles;
	}

	public Set<Elev> getListaCursElevi() {
		return listaCursElevi;
	}

	public void setListaCursElevi(Set<Elev> listaCursElevi) {
		this.listaCursElevi = listaCursElevi;
	}

	
	public Set<Curs> getListaCursuriProfesor() {
		return listaCursuriProfesor;
	}

	public void setListaCursuriProfesor(Set<Curs> listaCursuriProfesor) {
		this.listaCursuriProfesor = listaCursuriProfesor;
	}

	public Map<String, Integer> getEleviListaNote() {
		return eleviListaNote;
	}

	public void setEleviListaNote(Map<String, Integer> eleviListaNote) {
		this.eleviListaNote = eleviListaNote;
	}

	public String getElevNotaAcordata() {
		return elevNotaAcordata;
	}

	public void setElevNotaAcordata(String elevNotaAcordata) {
		this.elevNotaAcordata = elevNotaAcordata;
	}

	public String getElevNotaNume() {
		return elevNotaNume;
	}

	public void setElevNotaNume(String elevNotaNume) {
		this.elevNotaNume = elevNotaNume;
	}
	
	public String getNumeElevAles() {
		return numeElevAles;
	}

	public void setNumeElevAles(String numeElevAles) {
		this.numeElevAles = numeElevAles;
	}

	
	public Elev getElevModifica() {
		return elevModifica;
	}

	public void setElevModifica(Elev elevModifica) {
		this.elevModifica = elevModifica;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}


	
}
