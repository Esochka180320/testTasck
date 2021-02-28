package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ConstructorBinding
public class Month {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private String name;
    @Column(unique=true)
    private Integer number;

    public Month(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public Month() {

    }
}
