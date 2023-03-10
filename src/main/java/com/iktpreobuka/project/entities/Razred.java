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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Razred")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Razred {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String naziv;
	@Column(nullable = false)
	private Odeljenje odeljenje;
	@Version
	private Integer version;
	@JsonIgnore
	@OneToMany(mappedBy = "razred", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Predmet> predmet = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "razred", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ucenik> ucenik = new ArrayList<>();

	public Razred() {
		super();
	}

	public Razred(Integer id, String naziv, Odeljenje odeljenje, List<Predmet> predmet, List<Ucenik> ucenik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.odeljenje = odeljenje;
		this.predmet = predmet;
		this.ucenik = ucenik;
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

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public List<Predmet> getPredmet() {
		return predmet;
	}

	public void setPredmet(List<Predmet> predmet) {
		this.predmet = predmet;
	}

	public List<Ucenik> getUcenik() {
		return ucenik;
	}

	public void setUcenik(List<Ucenik> ucenik) {
		this.ucenik = ucenik;
	}

}
