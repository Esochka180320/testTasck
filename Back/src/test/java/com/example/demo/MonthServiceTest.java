package com.example.demo;

import com.example.demo.entity.Month;
import com.example.demo.repository.MonthRepository;
import com.example.demo.service.MonthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MonthServiceTest {

    @Autowired
    MonthService monthService;

    @MockBean
    MonthRepository monthRepository;

    private final String name = "December";
    private final Integer number = 12;
    private final String name2 = "November";
    private final Integer number2 = 11;
    Month month1 = new Month(name, number);
    Month month2 = new Month(name2, number2);
    List<Month> months = new ArrayList<>();


    @Test
    void addMonthTest_Pass() {
        Mockito.when(monthRepository.existsByName(name)).thenReturn(false);
        Mockito.when(monthRepository.save(month1)).thenReturn(month1);
        assertEquals(monthService.addMonth(month1), month1);
    }

    @Test
    void addMonthTest_Fail() {
        Mockito.when(monthRepository.existsByName(name)).thenReturn(true);
        assertNull(monthService.addMonth(month1));
    }

    @Test
    void findAllMonthTest_Pass() {
        months.add(month1);
        months.add(month2);
        Mockito.when(monthRepository.findAll()).thenReturn(months);
        assertEquals(monthService.findAllMonth(), months);
    }

    @Test
    void findAllMonthTest_Fail() {
        Mockito.when(monthRepository.findAll()).thenReturn(null);
        assertNull(monthService.findAllMonth());
    }

    @Test
    void findMonthTest_Pass() {
        months.add(month1);
        Mockito.when(monthRepository.findByNameContainingIgnoreCase(month1.getName())).thenReturn(months);
        assertEquals(monthService.findMonth(month1.getName()), months);
    }

    @Test
    void findMonthTest_Fail() {
        Mockito.when(monthRepository.findByNameContainingIgnoreCase(month1.getName())).thenReturn(null);
        assertNull(monthService.findMonth(month1.getName()));
    }


}
