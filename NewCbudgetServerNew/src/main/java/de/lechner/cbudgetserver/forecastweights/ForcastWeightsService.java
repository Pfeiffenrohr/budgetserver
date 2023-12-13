package de.lechner.cbudgetserver.forecastweights;

import de.lechner.cbudgetserver.konto.KontoRepository;
import de.lechner.cbudgetserver.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ForcastWeightsService {
    @Autowired
    private ForecastWeightsRepository forecastWeightsRepository;


    public ForecastWeights forecastWeightsByCategoryAndKonto (Map<String,String> params) throws ParseException {
        Integer konto = new Integer (params.get("konto"));
        Integer category = new Integer(params.get("category"));
        return  forecastWeightsRepository.findForecastWeightsByCategoryAndKonto(konto,category);
    }

}
