package com.iktpreobuka.project.entities.dto;

import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.iktpreobuka.project.entities.Uloga;

@Table(name = "korisnikDTO")
public class KorisnikDTO {

	@NotNull(message = "First name must be provided.")
	@Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.")
	private String ime;

	@NotNull(message = "Last name must be provided.")
	@Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.")
	private String prezime;

	@NotNull(message = "Username must be provided.")
	@Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.")
	private String korisnickoIme;

	@NotNull(message = "Password must be provided.")
	@Size(min = 5, max = 10, message = "Password must be between {min} and {max} characters long.")
	private String sifra;

	@NotNull(message = "Password must be provided.")
	private String confirmedPassword;

	@NotNull(message = "Role must be provided.")
	private Uloga uloga;

	public KorisnikDTO() {
		super();
	}

	public KorisnikDTO(
			@NotNull(message = "First name must be provided.") @Size(min = 2, max = 30, message = "First name must be between {min} and {max} characters long.") String ime,
			@NotNull(message = "Last name must be provided.") @Size(min = 2, max = 30, message = "Last name must be between {min} and {max} characters long.") String prezime,
			@NotNull(message = "Username must be provided.") @Size(min = 5, max = 15, message = "Username must be between {min} and {max} characters long.") String korisnickoIme,
			@NotNull(message = "Password must be provided.") @Size(min = 5, max = 10, message = "Password must be between {min} and {max} characters long.") String sifra,
			@NotNull(message = "Password must be provided.") String confirmedPassword,
			@NotNull(message = "Role must be provided.") Uloga uloga) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.confirmedPassword = confirmedPassword;
		this.uloga = uloga;
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

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getConfirmedPassword() {
		return confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

}