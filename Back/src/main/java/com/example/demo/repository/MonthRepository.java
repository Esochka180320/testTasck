package com.example.demo.repository;

import com.example.demo.entity.Month;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MonthRepository extends CrudRepository <Month, Integer> {

    Month findAllByName(String name);

    List<Month> findByNameContainingIgnoreCase(String name);

    void deleteByNumber(Integer number);

    boolean existsByName(String name);

    Month findByNumber(Integer number);
}
