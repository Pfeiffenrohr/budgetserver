package de.lechner.cbudgetserver.forecastweights;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ForecastWeightsRepository extends CrudRepository<ForecastWeights, Integer> {
    @Query(value= "select * from forecast_weights where konto =:konto and category =:kategorie" ,nativeQuery = true )
    ForecastWeights findForecastWeightsByCategoryAndKonto (@Param("konto") Integer konto, @Param("kategorie") Integer kategorie);
}
