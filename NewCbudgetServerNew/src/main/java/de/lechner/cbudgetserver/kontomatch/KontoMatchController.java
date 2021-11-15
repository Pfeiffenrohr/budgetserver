package de.lechner.cbudgetserver.kontomatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.lechner.cbudgetserver.konto.KontoService;

@RestController
public class KontoMatchController {
	
	@Autowired
	private KontoMatchService kontomatchservice;
	
	 @RequestMapping("/kontomatchByName/{name}")
	 public String getkontobyName(@PathVariable("name") String name) {
	     String  internal = kontomatchservice.getKontoMatchByName(name);
	     return internal;
	    
	 }
	
}
