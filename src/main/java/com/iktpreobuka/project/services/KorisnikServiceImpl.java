package com.iktpreobuka.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.project.entities.Korisnik;
import com.iktpreobuka.project.entities.Uloga;
import com.iktpreobuka.project.repositories.KorisnikRepository;
import com.iktpreobuka.project.repositories.RoditeljRepository;
import com.iktpreobuka.project.repositories.UcenikRepository;

@Service
public class KorisnikServiceImpl implements KorisnikService{

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public Iterable<Korisnik> preuzmiSveKorisnike() {
		// TODO Auto-generated method stub
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik dodajKorisnika(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return korisnikRepository.save(korisnik);
	}
 



}
