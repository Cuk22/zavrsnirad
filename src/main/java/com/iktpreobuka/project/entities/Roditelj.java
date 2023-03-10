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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Roditelj extends Korisnik{

	@JsonIgnore
	@OneToMany(mappedBy = "roditelj", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List<Ucenik> ucenik = new ArrayList<>();

	public Roditelj() {
		super();
	}

	public Roditelj(List<Ucenik> ucenik) {
		super();
		this.ucenik = ucenik;
	}

	public List<Ucenik> getUcenik() {
		return ucenik;
	}

	public void setUcenik(List<Ucenik> ucenik) {
		this.ucenik = ucenik;
	}

}