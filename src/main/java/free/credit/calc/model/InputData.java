package free.credit.calc.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Component
@Scope("prototype")
public class InputData {

    @NotNull
    @DecimalMin(value =  "100000")
    @DecimalMax(value = "5000000")
    @Value("100000")
    private BigDecimal summa;

    @Value("${default.prosent}")
    private BigDecimal prosent;

    @NotNull
    @Min(value = 12)
    @Max(value = 60)
    @Value("12")
    private Integer periodInMonths;

    public void setProsent(BigDecimal prosent) {
        this.prosent = prosent;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public BigDecimal getProsent() {
        return prosent;
    }

    public Integer getPeriodInMonths() {
        return periodInMonths;
    }

    public void setPeriodInMonths(Integer periodInMonths) {
        this.periodInMonths = periodInMonths;
    }
}
