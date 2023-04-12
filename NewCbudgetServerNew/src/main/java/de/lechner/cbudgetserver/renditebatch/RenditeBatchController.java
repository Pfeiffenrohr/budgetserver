package de.lechner.cbudgetserver.renditebatch;

import de.lechner.cbudgetserver.rendite.Rendite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RenditeBatchController {

    @Autowired
    private RenditeBatchService renditeBatchService;

    @GetMapping(value = "/hiRenditeBatch")
    public String sayHi() {
        return "hi";
    }


    @RequestMapping("/renditebatch/{id}")
    public RenditeBatch getRendite(@PathVariable("id") String id) {
        if (renditeBatchService==null) {
            System.out.println("Renditeservice = null!!!!");
            return (new RenditeBatch());
        }
        RenditeBatch trans = renditeBatchService.getRendite(new Integer(id));
        return renditeBatchService.getRendite(new Integer(id));
    }



    @RequestMapping(method=RequestMethod.POST, value="/renditebatch")
    public void addRendite(@RequestBody RenditeBatch rendite) {
        renditeBatchService.addRendite(rendite);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/renditebatch")
    public void updateRendite(@RequestBody RenditeBatch rendite) {
        renditeBatchService.updateRendite(rendite);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/renditebatch/{id}")
    public void deleteRendite(@PathVariable("id") String id) {
        renditeBatchService.deleteRendite(new Integer(id));
    }
}
