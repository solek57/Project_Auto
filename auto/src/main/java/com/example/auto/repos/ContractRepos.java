package com.example.auto.repos;


import com.example.auto.domain.Contract;

import org.springframework.data.repository.CrudRepository;




//Позволяет найти список полей

public interface ContractRepos extends CrudRepository<Contract, Long> {

}
