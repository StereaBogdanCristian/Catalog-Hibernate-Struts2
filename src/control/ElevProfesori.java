package control;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionContext;

import dbConnection.ReadProfesoriiUnuiElev;
import model.Elev;
import model.Profesor;

public class ElevProfesori {
	
	private Elev elev;
	private TreeSet<Profesor> listaProfesori;
	
	public String execute() {
	
	    elev = (Elev) ActionContext.getContext().getSession().get("elev");
	    ReadProfesoriiUnuiElev rpe = new ReadProfesoriiUnuiElev();
	    listaProfesori = rpe.getProfesoriiUnuiElev(elev);
	    
	    return "success";
	}
	
	public Elev getElev() {
		return elev;
	}

	public void setElev(Elev elev) {
		this.elev = elev;
	}

	public TreeSet<Profesor> getListaProfesori() {
		return listaProfesori;
	}

	public void setListaProfesori(TreeSet<Profesor> listaProfesori) {
		this.listaProfesori = listaProfesori;
	}

}
