package de.lechner.cbudgetserver.forecastweights;

import de.lechner.cbudgetserver.transaction.Transaction;
import de.lechner.cbudgetserver.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
public class ForecastWeightsController {
    @Autowired
    private ForcastWeightsService forcastWeightsService;

    @RequestMapping("/forecastweights")
    @ResponseBody
    public ForecastWeights getTransactionWithDate(@RequestParam Map<String,String> allParams) throws ParseException {
        ForecastWeights result = forcastWeightsService.forecastWeightsByCategoryAndKonto(allParams);
        return  result;
    }
}
