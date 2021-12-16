package de.lechner.cbudgetserver.anlage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnlageController {
    
    @Autowired
    private AnlageService anlageservice;
    
     @GetMapping(value = "/hiAnlage")
    public String sayHi() {
        return "hi";
    }
    
      @GetMapping(value = "/anlagen")
    public List <Anlage> getAll() {
          return anlageservice.getAllAnlagen();
        
      } 
      
     @RequestMapping("/anlage/{id}") 
     public Anlage getAnlage(@PathVariable("id") String id) {
         if (anlageservice==null) {
             System.out.println("Anlageservice = null!!!!");
             return (new Anlage());      
         }
             Anlage trans = anlageservice.getAnlage(new Integer(id));
         return anlageservice.getAnlage(new Integer(id));
    }
         
     @RequestMapping(method=RequestMethod.POST, value="/anlagen")
     public void addAnlage(@RequestBody Anlage anlage) {
         anlageservice.addAnlage(anlage);
     }
     
     @RequestMapping(method=RequestMethod.PUT, value="/anlagen")
     public void updateAnlage(@RequestBody Anlage anlage) {
         anlageservice.updateAnlage(anlage);
     }
    
     @RequestMapping(method=RequestMethod.DELETE,value="/anlage/{id}") 
     public void deleteAnlage(@PathVariable("id") String id) { 
         anlageservice.deleteAnlage(new Integer(id)); 
     }
}