package com.example.auto.controller;

import com.example.auto.domain.Auto;
import com.example.auto.repos.AutoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private AutoRepos autoRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Auto> aut = autoRepos.findAll();

        model.put("aut", aut);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String car_brand, @RequestParam Long price, Map<String, Object> model) {
        Auto auto = new Auto(car_brand, price);

        autoRepos.save(auto);

        Iterable<Auto> aut = autoRepos.findAll();

        model.put("aut", aut);

        return "main";
    }

    @PostMapping("filter")
    public String filter_price(@RequestParam Long filter, Map<String, Object> model) {
        Iterable<Auto> aut;


        if(filter <= 0 ){
            aut = autoRepos.findAll() ;
        }
        else{
            aut = autoRepos.findByPrice(filter);
        }
        model.put("aut", aut);

        return "main";
    }

    @GetMapping("/update/{id}")
    public String getById(@PathVariable long id , Map<String, Object> model){
        
        Iterable <Auto> autos = autoRepos.findById(id);
        model.put("autos" , autos) ;
        return"update" ;
    }

    @PostMapping("/updateAuto")
    public String updateAuto (@ModelAttribute("autos") Auto auto){

        autoRepos.save(auto) ;
        return "redirect:/main" ;
    }



    @GetMapping("/delete/{id}")
    @DeleteMapping("/delete/{id}")
    public  String deletAuto(@PathVariable("id") long id){

        autoRepos.deleteById(id);

        return "redirect:/main" ;
    }
}