package com.example.auto.domain;

import javax.persistence.*;
import java.util.Set;

@Table(name = "auto")
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String car_brand;
    private Long price;


    public Auto() {
    }

    public Auto(String car_brand, Long price) {
        this.car_brand = car_brand;
        this.price = price;
    }

    public Auto(long id, String car_brand, Long price) {
        this.id = id ;
        this.car_brand = car_brand;
        this.price = price;
    }

    // @OneToMany(fetch = FetchType.EAGER , mappedBy = "auto")
   // private Set<Contract> users ;

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }


    public String getCar_brand() {
        return car_brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
