package de.lechner.cbudgetserver.planinouthistory;

import de.lechner.cbudgetserver.planinouthistory.PlanInOutHist;
import de.lechner.cbudgetserver.planinouthistory.PlanInOutHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlainOutHistController {

    @Autowired
    private PlanInOutHistService planInOutHistService;

    @GetMapping(value = "/hiPlanInOutHist")
    public String sayHi() {
        return "hi";
    }

    @GetMapping(value = "/planInOutHists")
    public List<PlanInOutHist> getAll() {
        return planInOutHistService.getAllPlanInOutHists();

    }

    @RequestMapping("/planInOutHist/{id}")
    public PlanInOutHist getPlanInOut(@PathVariable("id") String id) {
        if (planInOutHistService==null) {
            System.out.println("PlanInOutHistService = null!!!!");
            return (new PlanInOutHist());
        }
        PlanInOutHist trans = planInOutHistService.getPlanInOutHist(new Integer(id));
        return planInOutHistService.getPlanInOutHist(new Integer(id));
    }

    @RequestMapping(method= RequestMethod.POST, value="/planInOutHists")
    public void addPlanInOutHist(@RequestBody PlanInOutHist PlanInOutHist) {
        planInOutHistService.addPlanInOutHist(PlanInOutHist);
    }

    @RequestMapping(method=RequestMethod.PUT, value="pPlanInOutHists")
    public void updatePlanInOutHist(@RequestBody PlanInOutHist PlanInOutHist) {
        planInOutHistService.updatePlanInOutHist(PlanInOutHist);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/planInOutHist/{id}")
    public void deletePlanInOutHist(@PathVariable("id") String id) {
        planInOutHistService.deletePlanInOutHist(new Integer(id));
    }
}
