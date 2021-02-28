package com.example.demo.service;

import com.example.demo.entity.Month;
import com.example.demo.repository.MonthRepository;
import com.example.demo.request.UpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MonthService {
    private final MonthRepository monthRepository;

    public MonthService(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    @Transactional
    public Month addMonth(Month month) {
        if (monthRepository.existsByName(month.getName())){
            return null;
        }
        return monthRepository.save(month);
    }

    @Transactional
    public List<Month> findAllMonth() {
        return (List<Month>) monthRepository.findAll();
    }

    @Transactional
    public List<Month> findMonth(String name) {
        return monthRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public Month updateMonth(UpdateRequest data) {
        if (monthRepository.existsByName(data.getNewName())){
            return null;
        }
        Month last = monthRepository.findByNumber(data.getNumber());
        last.setName(data.getNewName());
        last.setNumber(data.getNewNumber());
        return monthRepository.save(last);
    }

    @Transactional
    public void deleteMonth(Integer name) {
        monthRepository.deleteByNumber(name);
    }

}
