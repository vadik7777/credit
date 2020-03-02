package free.credit.calc.controller;

import free.credit.calc.model.InputData;
import free.credit.calc.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class CalcController {

    @Autowired
    CalcService calcService;

    @GetMapping(value= "/")
    public String index(Model model) {
        if (model.getAttribute("inputData") == null) {
            model.addAttribute("inputData", calcService.getInputData());
        }
        return "index";
    }

    @PostMapping(value="/")
    public String valid(@ModelAttribute @Valid InputData inputData, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors())
            return "index";
        redirectAttributes.addFlashAttribute(inputData);
        return "redirect:/result";
    }

    @GetMapping(value= "/result")
    public String result(Model model) {
        if (model.getAttribute("inputData") == null) {
            return "redirect:/";
        }
        model.addAttribute("raschet", calcService.raschet((InputData) model.getAttribute("inputData")));
        return "result";
    }
}
