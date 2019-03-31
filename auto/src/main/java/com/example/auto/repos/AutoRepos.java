package com.example.auto.repos;

import com.example.auto.domain.Auto;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Позволяет найти список полей

public interface AutoRepos extends CrudRepository<Auto, Long> {

    /*@Transactional
    @Modifying
    @Query(value = "update auto  set auto.car_brand = ?1  , auto.price = ?2 where auto.id = ?3")
    void update(String car_brand , String price);*/
    @Query("select a from Auto a where a.price <= ?1")
    List<Auto> findByPrice(long price);

    List <Auto> findById(long id) ;

    @Transactional
    void deleteById(long id);

}
