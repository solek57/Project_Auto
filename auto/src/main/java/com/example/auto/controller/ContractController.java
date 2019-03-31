package com.example.auto.controller;

import com.example.auto.domain.Contract;

import com.example.auto.repos.AutoRepos;
import com.example.auto.repos.ContractRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller

public class ContractController {

    @Autowired
    private ContractRepos contractRepos;
    @Autowired
    private AutoRepos autoRepos ;
    @GetMapping("/contract")
    public String cont() {
        return "contract";
    }

    @PostMapping("/contract")
    public String add_contract(@RequestParam String name, @RequestParam String email,@RequestParam Long id_auto ,  Map<String, Object> model) {
        Contract contract = new Contract(name, email , id_auto);

        contractRepos.save(contract);
        autoRepos.deleteById(id_auto);
        Iterable<Contract> all_contract = contractRepos.findAll();

        model.put("contract", all_contract);

        return "contract";

    }
}
