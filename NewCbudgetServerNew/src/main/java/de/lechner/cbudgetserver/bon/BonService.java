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
				System.out.println("rawnameMutant = >" + rawnameMutant +"<");
				
				return  bonRepository.findByrawnameMutant(rawnameMutant);
			}
			
			public void addBon(Bon bon)
			{
				//System.out.println("Add Bon " +bon.getRawnameMutant());
				try {
					//System.out.println("ID = "+bon.id );
					//bon.setId(0);
				bonRepository.save(bon);
				}
				catch (Exception e ) { e.fillInStackTrace();}
			}
			public void updateBon(Bon bon) {
				//System.out.println("Update Bon " +bon.getRawnameMutant());
				bonRepository.save(bon);
			}
			public void deleteBon(int id) {

				System.out.println("Add Bon " +id);
				bonRepository.deleteById(id);
			}
			
		}

