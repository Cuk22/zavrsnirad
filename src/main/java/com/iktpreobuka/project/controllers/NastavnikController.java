package com.iktpreobuka.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.project.entities.Korisnik;
import com.iktpreobuka.project.entities.Nastavnik;
import com.iktpreobuka.project.repositories.NastavnikRepository;
import com.iktpreobuka.project.services.NastavnikService;

@RestController
@RequestMapping("/api/v1/nastavnici")
public class NastavnikController {

	@Autowired
	private NastavnikService nastavnikService;
	
	@RequestMapping(method = RequestMethod.GET)
    public Iterable<Nastavnik> preuzmiSveNastavnike() {
        return nastavnikService.preuzmiSveNastavnike();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	    public Nastavnik dodajNastavnika(@RequestBody Nastavnik nastavnik) {
	        return nastavnikService.dodajNastavnika(nastavnik);
	    }
	
}
