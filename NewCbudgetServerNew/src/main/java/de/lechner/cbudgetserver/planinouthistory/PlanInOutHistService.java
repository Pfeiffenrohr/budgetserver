package de.lechner.cbudgetserver.planinouthistory;

import de.lechner.cbudgetserver.planinouthistory.PlanInOutHist;
import de.lechner.cbudgetserver.planinouthistory.PlanInOutHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PlanInOutHistService {
    
    @Autowired
    private PlanInOutHistRepository planInOutHistRepository;

    List<PlanInOutHist> planInOutHists = new ArrayList<PlanInOutHist>();

    public String greeting(String str) {
        return "Hi";
    }

    public List <PlanInOutHist> getAllPlanInOutHists() {
        List<PlanInOutHist> t = new ArrayList<PlanInOutHist>();
        planInOutHistRepository.findAll().forEach(t::add);
        return t;
        //return PlanInOutHists;
    }

    public PlanInOutHist getPlanInOutHist(Integer id) {
        Date datum = new Date();
        return  planInOutHistRepository.findById((id)).orElse(new PlanInOutHist(255,34,datum ,4000.0));
    }



    public void addPlanInOutHist(PlanInOutHist PlanInOutHist)
    {
        planInOutHistRepository.save(PlanInOutHist);
    }
    public void updatePlanInOutHist(PlanInOutHist trans) {
        planInOutHistRepository.save(trans);
    }
    public void deletePlanInOutHist(int id) {
        planInOutHistRepository.deleteById(id);
    }

}