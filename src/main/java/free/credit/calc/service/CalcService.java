package free.credit.calc.service;

import free.credit.calc.model.CalcData;
import free.credit.calc.model.InputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {

    @Autowired
    private InputData inputData;

    @Lookup
    public CalcData createCalcData(){
        return null;
    }

    public List<CalcData> raschet(InputData inputData){

        //Расчет ставки 10 знаков
        BigDecimal stavka = inputData.getProsent().divide(BigDecimal.valueOf(1200), 10, RoundingMode.HALF_EVEN);
        //Расчет ежемесячного платежа 10 знаков
        BigDecimal platejReal = inputData.getSumma().multiply(stavka)
                .divide(BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(1)
                                .divide(BigDecimal.valueOf(1).add(stavka).pow(inputData.getPeriodInMonths()), 10, RoundingMode.HALF_EVEN)),
                        10, RoundingMode.HALF_EVEN);
        //Округленный платеж
        BigDecimal platej = platejReal.setScale(2, RoundingMode.HALF_UP);
        //остаток задолженности на период
        BigDecimal ostatok = inputData.getSumma().setScale(2, RoundingMode.HALF_EVEN);
        //платеж по процентам
        BigDecimal platejProsent;
        //платеж по основному долгу
        BigDecimal platejDolg;
        //Список с данными
        List<CalcData> calcDataList = new ArrayList<>();
        //Элемент данных
        CalcData calcData;

        for(int i = 0; i < inputData.getPeriodInMonths(); i++){
            platejProsent = ostatok.multiply(stavka).setScale(10, RoundingMode.HALF_EVEN);
            platejDolg = platejReal.subtract(platejProsent);

            calcData = createCalcData();
            String monthYear = monthYearConvert(i);
            calcData.setMonthYear(monthYear);
            calcData.setPlatejProsent(platejProsent.setScale(2, RoundingMode.HALF_UP));
            calcData.setPlatejDolg(platejDolg.setScale(2, RoundingMode.HALF_UP));
            calcData.setOstatokDolg(ostatok.setScale(2, RoundingMode.HALF_UP));
            calcData.setPlatej(platej);
            calcDataList.add(calcData);

            ostatok = ostatok.subtract(platejDolg);
        }
        return calcDataList;
    }

    private String monthYearConvert(int month){
        int year = 1;
        if(month > 11){
            year = year + month/12;
            month = month - 12*(year - 1);
        }
        return month + 1 + "/" + year;
    }

    public InputData getInputData() {
        return inputData;
    }
}
