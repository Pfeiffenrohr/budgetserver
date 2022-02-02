package de.lechner.cbudgetserver.anlage;


    import java.util.ArrayList;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class AnlageService {
        
        @Autowired
        private AnlageRepository anlageRepository;

        List<Anlage> Anlagen = new ArrayList<Anlage>();
        
        public String greeting(String str) {
        return "Hi";
        }
                
        public List <Anlage> getAllAnlagen() {
            List<Anlage> t = new ArrayList<Anlage>();
            anlageRepository.findAll().forEach(t::add);
            return t;
            //return Anlages;
        }
        
        public Anlage getAnlage(Integer id) {
            return  anlageRepository.findById((id)).orElse(new Anlage());
        }
        
        public void addAnlage(Anlage Anlage)
        {
            anlageRepository.save(Anlage);
        }
        public void updateAnlage(Anlage trans) {
            anlageRepository.save(trans);
        }
        public void deleteAnlage(int id) {
            anlageRepository.deleteById(id);
        }
        
    }
