package com.iktpreobuka.project.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Ucenik")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Ucenik extends Korisnik {

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "roditelj")
	private Roditelj roditelj;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "razred")
	private Razred razred;
	@JsonIgnore
	@OneToMany(mappedBy = "ucenik", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ocena> ocena = new ArrayList<>();

	public Ucenik() {
		super();
	}

	public Ucenik(Roditelj roditelj, Razred razred, List<Ocena> ocena) {
		super();
		this.roditelj = roditelj;
		this.razred = razred;
		this.ocena = ocena;
	}

	public Roditelj getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Roditelj roditelj) {
		this.roditelj = roditelj;
	}

	public Razred getRazred() {
		return razred;
	}

	public void setRazred(Razred razred) {
		this.razred = razred;
	}

	public List<Ocena> getOcena() {
		return ocena;
	}

	public void setOcena(List<Ocena> ocena) {
		this.ocena = ocena;
	}

}