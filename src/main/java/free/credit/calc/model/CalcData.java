package free.credit.calc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Scope("prototype")
public class CalcData {

    String monthYear;
    BigDecimal platejDolg;
    BigDecimal platejProsent;
    BigDecimal ostatokDolg;
    BigDecimal platej;

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public BigDecimal getPlatejDolg() {
        return platejDolg;
    }

    public void setPlatejDolg(BigDecimal platejDolg) {
        this.platejDolg = platejDolg;
    }

    public BigDecimal getPlatejProsent() {
        return platejProsent;
    }

    public void setPlatejProsent(BigDecimal platejProsent) {
        this.platejProsent = platejProsent;
    }

    public BigDecimal getOstatokDolg() {
        return ostatokDolg;
    }

    public void setOstatokDolg(BigDecimal ostatokDolg) {
        this.ostatokDolg = ostatokDolg;
    }

    public BigDecimal getPlatej() {
        return platej;
    }

    public void setPlatej(BigDecimal platej) {
        this.platej = platej;
    }
}