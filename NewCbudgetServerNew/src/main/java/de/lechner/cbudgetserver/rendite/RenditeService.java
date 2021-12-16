package de.lechner.cbudgetserver.rendite;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	@Service
	public class RenditeService {
		
		@Autowired
		private RenditeRepository renditeRepository;

		List<Rendite> Kontos = new ArrayList<Rendite>();
		
		public String greeting(String str) {
		return "Hi";
		}
				
		public List <Rendite> getAllRendite() {
			List<Rendite> t = new ArrayList<Rendite>();
			renditeRepository.findAll().forEach(t::add);
			return t;
			//return Kontos;
		}
		
		public Rendite getRendite(Integer id) {
			return  renditeRepository.findById((id)).orElse(new Rendite());
		}
		
		public void addRendite(Rendite rendite)
		{
			renditeRepository.save(rendite);
		}
		
		public void updateRendite(Rendite rendite) {
			renditeRepository.save(rendite);
		}
		public void deleteRendite(int id) {
			renditeRepository.deleteById(id);
		}
		
	}


