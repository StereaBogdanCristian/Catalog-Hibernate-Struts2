package control;

import java.util.ArrayList;

import dbConnection.ReadElev;
import dbConnection.ReadWriteCurs;
import model.Curs;
import model.Elev;

public class GestioneazaElevi {
	
	private Elev elev;
	private String numeElevDelete;
	private ArrayList<String> listaElevCursuri;
	private ArrayList<Elev> listaElevi;
	private ArrayList<Curs> listaCursuri;
	private String numeElevUpdate;
	private Elev elevUpdate;
	private ArrayList<String> listaElevCursuriUpdate = new ArrayList<String>();
	
	

	public String listaElevi() {
		
		ReadElev re = new ReadElev();
		ReadWriteCurs rwc = new ReadWriteCurs();
		listaElevi = re.getListaElevi();
		this.listaCursuri = rwc.getListaCursuri();
		
		return "success";
		
	}
	
	public String addElev() {
		ReadElev re = new ReadElev();
		re.add(getElev(), getListaElevCursuri());
		return "success";
	}
	
	public String deleteElev() {
		ReadElev re = new ReadElev();
		re.deleteElev(getNumeElevDelete());
		
		
		System.out.println(getNumeElevDelete());
		
		
		return "success";
	}
	
	public String updateElev() {
		
		ReadElev re = new ReadElev();
		elevUpdate=re.getElev(getNumeElevUpdate());
		for (Curs curs : elevUpdate.getListaElevCurs()) {
			listaElevCursuriUpdate.add(curs.getNume());
		}
		return "success";
	}

	public Elev getElev() {
		return elev;
	}

	public void setElev(Elev elev) {
		this.elev = elev;
	}

	public ArrayList<Elev> getListaElevi() {
		return listaElevi;
	}

	public void setListaElevi(ArrayList<Elev> listaElevi) {
		this.listaElevi = listaElevi;
	}

	public ArrayList<Curs> getListaCursuri() {
		return listaCursuri;
	}

	public void setListaCursuri(ArrayList<Curs> listaCursuri) {
		this.listaCursuri = listaCursuri;
	}

	public String getNumeElevDelete() {
		return numeElevDelete;
	}

	public void setNumeElevDelete(String numeElevDelete) {
		this.numeElevDelete = numeElevDelete;
	}

	public ArrayList<String> getListaElevCursuri() {
		return listaElevCursuri;
	}

	public void setListaElevCursuri(ArrayList<String> listaElevCursuri) {
		this.listaElevCursuri = listaElevCursuri;
	}

	public Elev getElevEdit() {
		return elevUpdate;
	}

	public void setElevEdit(Elev elevUpdate) {
		this.elevUpdate = elevUpdate;
	}

	public String getNumeElevUpdate() {
		return numeElevUpdate;
	}

	public void setNumeElevUpdate(String numeElevUpdate) {
		this.numeElevUpdate = numeElevUpdate;
	}

	public Elev getElevUpdate() {
		return elevUpdate;
	}

	public void setElevUpdate(Elev elevUpdate) {
		this.elevUpdate = elevUpdate;
	}

	public ArrayList<String> getListaElevCursuriUpdate() {
		return listaElevCursuriUpdate;
	}

	public void setListaElevCursuriUpdate(ArrayList<String> listaElevCursuriUpdate) {
		this.listaElevCursuriUpdate = listaElevCursuriUpdate;
	}

	
}
