package de.lechner.cbudgetserver.planinouthistory;

import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity

public class PlanInOutHist {

    @Id
    private Integer id;
    private Integer plan_id;
    private Date datum;
    private Double value;

    public PlanInOutHist(int i, int i1, Date datum, double v) {
    }

    public PlanInOutHist() {

    }
}
