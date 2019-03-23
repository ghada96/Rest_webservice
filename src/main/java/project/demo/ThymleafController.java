package project.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
@Controller
public class ThymleafController {
    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("username","ghada");
        model.addAttribute("date",new Date());
        return "index";

    }
}
