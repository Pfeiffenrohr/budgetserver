package de.lechner.cbudgetserver.renditebatch;

import de.lechner.cbudgetserver.renditebatch.RenditeBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RenditeBatchService {

    @Autowired
    private RenditeBatchRepository renditeBatchRepository;

    List<RenditeBatch> RenditeBatch = new ArrayList<RenditeBatch>();

    public String greeting(String str) {
        return "Hi";
    }

    public List <RenditeBatch> getAllRendite() {
        List<RenditeBatch> t = new ArrayList<RenditeBatch>();
        renditeBatchRepository.findAll().forEach(t::add);
        return t;
        //return Kontos;
    }

    public RenditeBatch getRendite(Integer id) {
        return  renditeBatchRepository.findById((id)).orElse(new RenditeBatch());
    }


    public void addRendite(RenditeBatch renditeBatch)
    {
        renditeBatchRepository.save(renditeBatch);
    }

    public void updateRendite(RenditeBatch renditeBatch) {
        renditeBatchRepository.save(renditeBatch);
    }
    public void deleteRendite(int id) {
        renditeBatchRepository.deleteById(id);
    }

}


