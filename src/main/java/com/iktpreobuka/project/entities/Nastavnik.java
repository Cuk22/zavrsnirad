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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Nastavnik")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nastavnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String ime;
	@Column(nullable = false)
	private String prezime;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Nastavnik_Predmet", joinColumns = {
			@JoinColumn(name = "Nastavnik_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Predmet_id", nullable = false, updatable = false) })
	private Set<Predmet> predmet = new HashSet<Predmet>();

	public Nastavnik() {
		super();
	}

	public Nastavnik(Integer id, String ime, String prezime, Set<Predmet> predmet) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.predmet = predmet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Set<Predmet> getPredmet() {
		return predmet;
	}

	public void setPredmet(Set<Predmet> predmet) {
		this.predmet = predmet;
	}

}
