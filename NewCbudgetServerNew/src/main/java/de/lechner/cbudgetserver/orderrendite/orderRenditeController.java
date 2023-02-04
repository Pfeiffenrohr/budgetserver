package de.lechner.cbudgetserver.orderrendite;

import de.lechner.cbudgetserver.konto.Konto;
import de.lechner.cbudgetserver.orderrendite.OrderRendite;
import de.lechner.cbudgetserver.orderrendite.OrderRenditeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class orderRenditeController {

    @Autowired
    private OrderRenditeService orderRenditeservice;

     @GetMapping(value = "/hiOrderRendite")
    public String sayHi() {
        return "hi";
    }

      @GetMapping(value = "/allOrderRendite")
    public List <OrderRendite> getAll() {
          return orderRenditeservice.getAllOrderRendite();

      }

     @RequestMapping("/orderRendite/{id}")
     public OrderRendite getOrderRendite(@PathVariable("id") String id) {
         if (orderRenditeservice==null) {
             System.out.println("OrderRenditeservice = null!!!!");
             return (new OrderRendite());
         }
         OrderRendite trans = orderRenditeservice.getOrderRendite(new Integer(id));
         return orderRenditeservice.getOrderRendite(new Integer(id));
    }



     @RequestMapping(method=RequestMethod.POST, value="/orderRendite")
     public void addOrderRendite(@RequestBody OrderRendite OrderRendite) {
         orderRenditeservice.addOrderRendite(OrderRendite);
     }

     @RequestMapping(method=RequestMethod.PUT, value="/orderRendite")
     public void updateOrderRendite(@RequestBody OrderRendite OrderRendite) {
         orderRenditeservice.updateOrderRendite(OrderRendite);
     }

     @RequestMapping(method=RequestMethod.DELETE,value="/orderRendite/{id}")
     public void deleteOrderRendite(@PathVariable("id") String id) {
         orderRenditeservice.deleteOrderRendite(new Integer(id));
     }
}
