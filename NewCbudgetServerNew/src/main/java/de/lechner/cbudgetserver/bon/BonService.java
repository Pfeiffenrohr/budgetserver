package de.lechner.cbudgetserver.bon;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	@Service
	public class BonService {
		
			
			@Autowired
			private BonRepository bonRepository;

			List<Bon> Bons = new ArrayList<Bon>();
			
			public String greeting(String str) {
			return "Hi";
			}
					
			public List <Bon> getAllBons() {
				List<Bon> t = new ArrayList<Bon>();
				bonRepository.findAll().forEach(t::add);
				return t;
				//return Bons;
			}
			
			public Bon getBon(Integer id) {
				return  bonRepository.findById((id)).orElse(new Bon(1,"Netto","Käse","Käse","Edam2",2));
			}
			
			public Bon getBonByRawname(String  rawnameMutant) {
				rawnameMutant= rawnameMutant.replace("%20" , " ").replace("%2C", ",");
			
				
				return  bonRepository.findByrawnameMutant(rawnameMutant);
			}
			
			public void addBon(Bon bon)
			{
				
				try {
					
				bonRepository.save(bon);
				}
				catch (Exception e ) { e.fillInStackTrace();}
			}
			public void updateBon(Bon bon) {
				
				bonRepository.save(bon);
			}
			public void deleteBon(int id) {

			
				bonRepository.deleteById(id);
			}
			
		}

