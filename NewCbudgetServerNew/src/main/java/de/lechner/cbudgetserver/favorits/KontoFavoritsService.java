package de.lechner.cbudgetserver.favorits;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KontoFavoritsService {
	
	@Autowired
	private KontoFavoritsRepository KontoFavoritsRepository;

	List<KontoFavorits> KontoFavoritss = new ArrayList<KontoFavorits>();
	
	public String greeting(String str) {
	return "Hi";
	}
			
	public List <KontoFavorits> getAllKontoFavoritss() {
		List<KontoFavorits> t = new ArrayList<KontoFavorits>();
		KontoFavoritsRepository.findAll().forEach(t::add);
		return t;
		//return KontoFavoritss;
	}
	
	public KontoFavorits getKontoFavorits(Integer id) {
		return  KontoFavoritsRepository.findById((id)).orElse(new KontoFavorits(1,2,3));
	}
	
	public void addKontoFavorits(KontoFavorits kontoFavorits)
	{
		KontoFavoritsRepository.save(kontoFavorits);
	}
	public void updateKontoFavorits(KontoFavorits trans) {
		KontoFavoritsRepository.save(trans);
	}
	public void deleteKontoFavorits(int id) {
		KontoFavoritsRepository.deleteById(id);
	}
	
}


