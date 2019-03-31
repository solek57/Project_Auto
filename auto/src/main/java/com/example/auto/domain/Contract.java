package com.example.auto.domain;

import javax.persistence.*;


@Table(name = "Contract")
@Entity
public class Contract {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private String name;
        private String email;
        private Long id_auto ;


        public Contract(){

        }

    public Contract(String name, String email, Long id_auto) {
        this.name = name;
        this.email = email;
        this.id_auto = id_auto;

    }

   // @ManyToOne(fetch = FetchType.EAGER , cascade  = CascadeType.MERGE)
   //     @JoinColumn(name = "auto_id" , nullable = false)


        public Integer getId() {

            return id;
        }

    public Long getId_auto() {
        return id_auto;
    }

    public void setId_auto(Long id_auto) {
        this.id_auto = id_auto;
    }



    public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

