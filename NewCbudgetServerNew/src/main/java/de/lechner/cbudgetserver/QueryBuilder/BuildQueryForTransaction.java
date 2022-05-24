package de.lechner.cbudgetserver.QueryBuilder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.lechner.cbudgetserver.rules.RuleService;
import de.lechner.cbudgetserver.transaction.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BuildQueryForTransaction {

    private static final Logger LOG = LoggerFactory.getLogger(BuildQueryForTransaction.class);

    @Autowired
    private RuleService ruleService;

    @Autowired
    EntityManager em;

    public String buildQuery(Integer ruleId, String startdate, String enddate,Integer konto) {
        em.getEntityManagerFactory();
        String command = ruleService.getCopmmandByRuleId(ruleId);
        if (command==null)
        {
            //Setze dummy
            command=" 1 =1 ";
        }
        // Transaction transaction = em.find(Transaction.class);
        // LOG.info("Query Where Command: "+command);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
        String query = "Select sum(wert) from Transaction where datum > '" + startdate + "' and datum < '" + enddate
                + "' and konto_id = " + konto + " and " + command;
        //System.out.println(query);
        
        Query q = em.createQuery(query);
        Double result = (Double) q.getSingleResult();
        // System.out.println("BuildQuery mit konto");
        if (result==null)
        {
            result=0.0;
        }
        return result.toString();
        /*
         * Root <Transaction> trans = cq.from(Transaction.class);
         * 
         * String mode = ruleService.getModeByRuleId(ruleId); List <RuleItem> ruleItems
         * = ruleItemService.getAllRullItemsPerRuleId(ruleId); Predicate predicate
         * =null; for (int i = 0; i<ruleItems.size(); i++) { RuleItem ruleItem =
         * ruleItems.get(i); String art = ruleItem.getArt(); Predicate pred =null; if
         * (art.equals("betrag")) { pred = getBetrag
         * (cb,trans,ruleItem.getOperator(),new Double(ruleItem.getValue())); }//betrag
         * if (art.equals("title")) { pred =
         * getTitle(cb,trans,ruleItem.getOperator(),ruleItem.getValue()); }//title if
         * (art.equals("konto")) { pred =
         * getKonto(cb,trans,ruleItem.getOperator(),ruleItem.getValue()); }//konto if
         * (art.equals("category")) { pred =
         * getCategory(cb,trans,ruleItem.getOperator(),ruleItem.getValue()); }//title
         * 
         * if (predicate == null) { predicate=pred; } else { if (mode.equals("alle")) {
         * predicate = cb.and(predicate,pred); } else { predicate =
         * cb.or(predicate,pred); } } } cq.where(predicate); List <Transaction> result =
         * em.createQuery(cq).getResultList();
         */
    }
    
    public String buildQuery(Integer ruleId, String startdate, String enddate) {
        em.getEntityManagerFactory();
        String command = ruleService.getCopmmandByRuleId(ruleId);
        // Transaction transaction = em.find(Transaction.class);
       // LOG.info("Query Where Command: "+command);
       // System.out.println("BuildQuery ohne konto");
        if (command==null)
        {
            //Setze dummy
            command=" 1 =1 ";
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
        String query = "Select sum(wert) from Transaction where datum > '" + startdate + "' and datum < '" + enddate
                + "' and " + command;
        //LOG.info("Command: "+query);
        Query q = em.createQuery(query);
        Double result = (Double) q.getSingleResult();
        
        if ( result == null) {
           // System.out.println(query);
            result=0.0;
        }
         
        return result.toString();
      
    }
    /*
     * private Predicate getCategory (CriteriaBuilder cb, Root <Transaction>
     * trans,String operator,String value) { //TODO Implement "startswith" and
     * "endswith" if (operator.equals("eq")) { Predicate ped =
     * cb.equal(trans.get("kategorie"), value); return ped; } if
     * (operator.equals("ne")) { Predicate ped = cb.equal(trans.get("kategorie"),
     * value); return ped; }
     * LOG.error("Operator in getCategory in RuleItems notfound!!"); return null;
     * 
     * }
     */
}