package com.iktpreobuka.project.services;

import java.util.List;

import com.iktpreobuka.project.entities.Korisnik;
import com.iktpreobuka.project.entities.Uloga;

public interface KorisnikService {
	 Iterable<Korisnik> preuzmiSveKorisnike();
	 Korisnik dodajKorisnika(Korisnik korisnik);


}
