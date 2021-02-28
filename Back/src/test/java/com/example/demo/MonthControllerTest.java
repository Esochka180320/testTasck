package com.example.demo;

import com.example.demo.controller.MonthController;
import com.example.demo.entity.Month;
import com.example.demo.service.MonthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MonthControllerTest {
    @Autowired
    MonthController monthController;

    @MockBean
    MonthService monthService;

    private final String name = "December";
    private final Integer number = 12;
    private final String name2 = "November";
    private final Integer number2 = 11;
    Month month1 = new Month(name, number);
    Month month2 = new Month(name2, number2);
    List<Month> months = new ArrayList<>();

    @Test
    void addMonthTest_Pass() {
        Mockito.doReturn(month1)
                .when(monthService)
                .addMonth(month1);

        assertEquals(ResponseEntity.ok(monthController.addMonth(month1)).getStatusCode(),
                monthController.addMonth(month1).getStatusCode());
    }

    @Test
    void addMonthTest_Fail() {
        Mockito.doReturn(null)
                .when(monthService)
                .addMonth(month1);

        assertEquals(ResponseEntity.ok(monthController.addMonth(month1)).getStatusCode(),
                monthController.addMonth(month1).getStatusCode());
    }

    @Test
    void findMonthTest_Pass() {
        Mockito.doReturn(months)
                .when(monthService)
                .findMonth(month1.getName());

        assertEquals(ResponseEntity.ok(monthController.findMonth(month1.getName())).getStatusCode(),
                monthController.findMonth(month1.getName()).getStatusCode());
    }

    @Test
    void findMonthTest_Fail() {
        Mockito.doReturn(null)
                .when(monthService)
                .findMonth(month1.getName());

        assertEquals(ResponseEntity.ok(monthController.findMonth(month1.getName())).getStatusCode(),
                monthController.findMonth(month1.getName()).getStatusCode());
    }

    @Test
    void findAllMonthTest_Pass() {
        Mockito.doReturn(months)
                .when(monthService)
                .findAllMonth();

        assertEquals(ResponseEntity.ok(monthController.findAllMonth()).getStatusCode(),
                monthController.findAllMonth().getStatusCode());
    }

    @Test
    void findAllMonthTest_Fail() {
        Mockito.doReturn(null)
                .when(monthService)
                .findAllMonth();

        assertEquals(ResponseEntity.ok(monthController.findAllMonth()).getStatusCode(),
                monthController.findAllMonth().getStatusCode());
    }


}
