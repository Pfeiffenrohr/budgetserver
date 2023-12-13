package de.lechner.cbudgetserver.forecastweights;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forecast_weights")
public class ForecastWeights {
    @Id
    private Integer id;
    private Integer category;
    private Integer konto;
    private Double y1;
    private Double y2;
    private Double y3;
    private Double precision;

    public ForecastWeights(Integer id, Integer category, Integer konto, Double y1, Double y2, Double y3, Double precision) {
        this.id = id;
        this.category = category;
        this.konto = konto;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.precision = precision;
    }

    public ForecastWeights() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getKonto() {
        return konto;
    }

    public void setKonto(Integer konto) {
        this.konto = konto;
    }

    public Double getY1() {
        return y1;
    }

    public void setY1(Double y1) {
        this.y1 = y1;
    }

    public Double getY2() {
        return y2;
    }

    public void setY2(Double y2) {
        this.y2 = y2;
    }

    public Double getY3() {
        return y3;
    }

    public void setY3(Double y3) {
        this.y3 = y3;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }
}
