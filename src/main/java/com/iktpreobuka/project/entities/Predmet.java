package com.iktpreobuka.project.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Predmet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String naziv;
	@Column(nullable = false)
	private Integer fondCasova;
	@Version
	private Integer version;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Nastavnik_Predmet", joinColumns = {
			@JoinColumn(name = "Predmet_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Nastavnik_id", nullable = false, updatable = false) })
	private Set<Nastavnik> nastavnik = new HashSet<Nastavnik>();
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "razred")
	private Razred razred;
	@JsonIgnore
	@OneToMany(mappedBy = "predmet", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ocena> ocena = new ArrayList<>();

	public Predmet() {
		super();
	}

	public Predmet(Integer id, String naziv, Integer fondCasova, Integer version, Set<Nastavnik> nastavnik,
			Razred razred, List<Ocena> ocena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fondCasova = fondCasova;
		this.version = version;
		this.nastavnik = nastavnik;
		this.razred = razred;
		this.ocena = ocena;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getFondCasova() {
		return fondCasova;
	}

	public void setFondCasova(Integer fondCasova) {
		this.fondCasova = fondCasova;
	}

	public Set<Nastavnik> getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Set<Nastavnik> nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Razred getRazred() {
		return razred;
	}

	public void setRazred(Razred razred) {
		this.razred = razred;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<Ocena> getOcena() {
		return ocena;
	}

	public void setOcena(List<Ocena> ocena) {
		this.ocena = ocena;
	}

}
