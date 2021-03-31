package dataconnect1.demo.controller;

import dataconnect1.demo.domain.Address;
import dataconnect1.demo.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {
    @GetMapping("/info")
    public String infoExpression(Model model)
    {
        Address address = new Address("92992 Ora st","Cali","IA","525255");
        Person cherry = new Person(2,"Pham",address);
        model.addAttribute("person",cherry);
        return "info";
    }
}
