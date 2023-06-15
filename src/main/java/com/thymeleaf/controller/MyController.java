package com.thymeleaf.controller;

import com.thymeleaf.model.LoginData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/about")
    public String about(Model model){

        model.addAttribute("name","Ali Raza");
        model.addAttribute("currentDate", new Date());

        System.out.println("Inside about handler");
        return "about";
    }



    @GetMapping("/list")
    public String nameOfList(Model m){

        List<String> names = List.of("Yaseen","Kamran","Sohail","Zahid","Abrar");
        m.addAttribute("names",names);



        return "iterate";
    }


    @GetMapping("/condition")
    public String ConditionalHandler(Model m){
        m.addAttribute("isActive",false);
        m.addAttribute("gender","F");

        List<Integer> list = List.of(23,134,123,133,432,12,32);
        m.addAttribute("myList",list);


        return "conditional";
    }


    @GetMapping("/form")
    public String openForm(Model model){
        System.out.println("opening form");
        model.addAttribute("loginData", new LoginData());
        return "form";
    }


    //handle for process form
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result){

        if(result.hasErrors()){
            System.out.println(result);
        }

        return "success";
    }
}
