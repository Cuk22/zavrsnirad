package com.iktpreobuka.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.Korisnik;
import com.iktpreobuka.project.repositories.KorisnikRepository;
import com.iktpreobuka.project.services.KorisnikService;

@RestController
@RequestMapping("/api/v1/korisnici")
public class KorisnikController {

	@Autowired
    private KorisnikService korisnikService;

/*	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Korisnik> postaviKorisnika(@RequestBody Korisnik korisnik) {
        Korisnik noviKorisnik = korisnikRepository.save(korisnik);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }*/
  
	@RequestMapping(method = RequestMethod.GET)
    public Iterable<Korisnik> preuzmiSveKorinike() {
        return korisnikService.preuzmiSveKorisnike();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	    public Korisnik dodajKoriniska(@RequestBody Korisnik korisnik) {
	        return korisnikService.dodajKorisnika(korisnik);
	    }
	
}
