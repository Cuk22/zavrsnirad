package com.iktpreobuka.project.services;

import com.iktpreobuka.project.entities.Korisnik;
import com.iktpreobuka.project.entities.Nastavnik;

public interface NastavnikService {
	 Iterable<Nastavnik> preuzmiSveNastavnike();
	 Nastavnik dodajNastavnika(Nastavnik nastavnik);
}
