package control;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionContext;

import dbConnection.ReadEleviiUnuiProfesor;
import model.Elev;
import model.Profesor;

public class ProfesorElevi {
	
	private Profesor profesor;
	private TreeSet<Elev> listaElevi;
	
	public String execute() {
	
	    profesor = (Profesor) ActionContext.getContext().getSession().get("profesor");
	    ReadEleviiUnuiProfesor rep = new ReadEleviiUnuiProfesor();
	    listaElevi = rep.getEleviiUnuiProfesor(profesor);
	    
	    return "success";
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public TreeSet<Elev> getListaElevi() {
		return listaElevi;
	}

	public void setListaElevi(TreeSet<Elev> listaElevi) {
		this.listaElevi = listaElevi;
	}

	
	
}
