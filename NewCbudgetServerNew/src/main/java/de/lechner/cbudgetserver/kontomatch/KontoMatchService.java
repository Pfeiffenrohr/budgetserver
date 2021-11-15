package de.lechner.cbudgetserver.kontomatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class KontoMatchService {

	@Autowired
	private KontoMatchRepository kontoMatchRepository;
	
	
	public String getKontoMatchByName(String name) {
		return  kontoMatchRepository.findByName((name));
	}
}
