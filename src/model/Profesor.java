package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Profesor {
	
	@Id @GeneratedValue
	private int id;
	private String nume;
	private String cont;
	private String parola;
	@OneToMany (fetch=FetchType.EAGER)
	@JoinTable(name = "Lista_Profesor_Curs",
			joinColumns=@JoinColumn(name = "Profesor_Id"),
			inverseJoinColumns=@JoinColumn(name = "Curs_Id"))
	private Set<Curs> listaProfesorCurs = new HashSet<Curs>();
	
	
	
	
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
	
	public Set<Curs> getListaProfesorCurs() {
		return listaProfesorCurs;
	}
	public void setListaProfesorCurs(Set<Curs> listaProfesorCurs) {
		this.listaProfesorCurs = listaProfesorCurs;
	}
	public void afiseazaCursuri() {
		for (Curs curs : listaProfesorCurs) {
			System.out.println(curs.getNume());
		}
	}

}
