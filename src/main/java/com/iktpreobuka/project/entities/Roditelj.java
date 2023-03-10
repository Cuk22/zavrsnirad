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
@Table(name = "Roditelj")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Roditelj {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private String ime;
	@Column(nullable = false)
	private String prezime;
	@Column(nullable = false)
	private String email;
	@Version
	private Integer version;
	@JsonIgnore
	@OneToMany(mappedBy = "roditelj", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private List<Ucenik> ucenik = new ArrayList<>();

	public Roditelj() {
		super();
	}

	public Roditelj(Integer id, String ime, String prezime, String email, List<Ucenik> ucenik) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.ucenik = ucenik;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Ucenik> getUcenik() {
		return ucenik;
	}

	public void setUcenik(List<Ucenik> ucenik) {
		this.ucenik = ucenik;
	}

}
