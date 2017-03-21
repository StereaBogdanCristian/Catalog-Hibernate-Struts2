package control;

import java.util.ArrayList;

import dbConnection.ReadProfesor;
import model.Profesor;

public class GestioneazaProfesori {

	private Profesor profesor;
	private String numeProfesorDelete;
	private ArrayList<Profesor> listaProfesori;
	
	
	public String listaProfesori() {
		
		ReadProfesor rp = new ReadProfesor();
		this.listaProfesori = rp.getListaProfesori();
		
		return "success";
	}
	
	public String addProfesor() {
		
		ReadProfesor rp = new ReadProfesor();
		rp.addProfesor(getProfesor());
		
		return "success";
	}
	
	public String deleteProfesor() {
		ReadProfesor rp = new ReadProfesor();
		rp.deleteProfesor(getNumeProfesorDelete());
		
		return "success";
		
	}
	
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public String getNumeProfesorDelete() {
		return numeProfesorDelete;
	}
	public void setNumeProfesorDelete(String numeProfesorDelete) {
		this.numeProfesorDelete = numeProfesorDelete;
	}
	public ArrayList<Profesor> getListaProfesori() {
		return listaProfesori;
	}
	public void setListaProfesori(ArrayList<Profesor> listaProfesori) {
		this.listaProfesori = listaProfesori;
	}
	
	
}
