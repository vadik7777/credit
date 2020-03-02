package free.credit.calc;

import free.credit.calc.controller.CalcController;
import free.credit.calc.service.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CalcController.class)
@ComponentScan(basePackages = { "free.credit.calc" })
public class CalcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalcService calcService;

    @Test
    public void main() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("inputData", is (calcService.getInputData())))
                .andExpect(content().string(containsString("Рассчитать")));
    }

    @Test
    public void resultRedirectWithError() throws Exception{
        mockMvc.perform(post("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("inputData", instanceOf (calcService.getInputData().getClass())))
                .andExpect(content().string(containsString("Рассчитать")));
    }

    @Test
    public void resultRedirectWithOutError() throws Exception{
        mockMvc.perform(post("/").flashAttr("inputData", calcService.getInputData()))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void resultGetWithError() throws Exception{
        mockMvc.perform(get("/result"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void resultGetWithOutError() throws Exception{
        mockMvc.perform(get("/result").flashAttr("inputData", calcService.getInputData()))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("raschet", equalTo (calcService.raschet(calcService.getInputData()))))
                .andExpect(content().string(containsString("Общая сумма платежа")));
    }
}
