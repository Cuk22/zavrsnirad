package com.iktpreobuka.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.project.entities.Korisnik;
import com.iktpreobuka.project.entities.Nastavnik;
import com.iktpreobuka.project.repositories.NastavnikRepository;

@Service
public class NastavnikServiceImpl implements NastavnikService {

	@Autowired
	private NastavnikRepository nastavnikRepository;
	
	@Override
	public Iterable<Nastavnik> preuzmiSveNastavnike() {
		// TODO Auto-generated method stub
		return nastavnikRepository.findAll();
	}

	@Override
	public Nastavnik dodajNastavnika(Nastavnik nastavnik) {
		// TODO Auto-generated method stub
		return nastavnikRepository.save(nastavnik);
	}

}
