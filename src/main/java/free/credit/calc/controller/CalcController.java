package free.credit.calc.controller;

import free.credit.calc.model.InputData;
import free.credit.calc.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Scope("session")
public class CalcController {

    @Autowired
    CalcService calcService;

    @GetMapping(value= "/")
    public String index(Model model) {
        model.addAttribute("inputData", calcService.getInputData());
        return "index";
    }

    @PostMapping(value="/")
    public String result(@ModelAttribute @Valid InputData inputData, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
            return "index";
        model.addAttribute("inputData", inputData);
        model.addAttribute("raschet", calcService.raschet(inputData));
        return "result";
    }
}
