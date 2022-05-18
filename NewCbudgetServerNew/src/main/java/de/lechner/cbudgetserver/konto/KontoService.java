package de.lechner.cbudgetserver.konto;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	@Service
	public class KontoService {
		
		@Autowired
		private KontoRepository KontoRepository;

		List<Konto> Kontos = new ArrayList<Konto>();
		
		public String greeting(String str) {
		return "Hi";
		}
				
		public List <Konto> getAllKontos() {
			List<Konto> t = new ArrayList<Konto>();
			KontoRepository.findAll().forEach(t::add);
			return t;
			//return Kontos;
		}
		
		public Konto getKonto(Integer id) {
			return  KontoRepository.findById((id)).orElse(new Konto(255,"name3","y",4000.0,2000.0,"desc","mode",-1));
		}
		
		public Integer getKontoByName(String name) {
			return  KontoRepository.findByName((name));
		}
		
		
		public void addKonto(Konto Konto)
		{
			KontoRepository.save(Konto);
		}
		public void updateKonto(Konto trans) {
			KontoRepository.save(trans);
		}
		public void deleteKonto(int id) {
			KontoRepository.deleteById(id);
		}
		
	}


