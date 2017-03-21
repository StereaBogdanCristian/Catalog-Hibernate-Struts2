package model;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Elev {
	
	@Id @GeneratedValue
	private int id;
	private String nume;
	private String cont;
	private String parola;
	@ManyToMany (fetch=FetchType.EAGER)
	@JoinTable(name = "Lista_Elev_Curs",
			joinColumns=@JoinColumn(name = "Id_Elev"),
			inverseJoinColumns=@JoinColumn(name = "Id_Curs"))
	private Set<Curs> listaElevCurs = new HashSet<Curs>();
	//@ElementCollection (fetch=FetchType.EAGER)
	//@JoinTable (name = "Lista_Note")
	//private List<Note> listaNote = new ArrayList<Note>();
	private TreeMap<String, Integer> listaNote = new TreeMap<String, Integer>();
	
	
	
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	
	public Set<Curs> getListaElevCurs() {
		return listaElevCurs;
	}
	
	public void setListaElevCurs(Set<Curs> listaElevCurs) {
		this.listaElevCurs = listaElevCurs;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public TreeMap<String, Integer> getListaNote() {
		return listaNote;
	}
	public void setListaNote(TreeMap<String, Integer> listaNote) {
		this.listaNote = listaNote;
	}
	
	
}
