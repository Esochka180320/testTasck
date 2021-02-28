package com.example.demo;


import com.example.demo.entity.Month;
import com.example.demo.utils.ValidateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ValidateTest {
    @Autowired
    ValidateUtils validateUtils;

    private final String name = "December";
    private final Integer number = 12;
    private final String name2 = "November";
    private final Integer number2 = 10;
    Month month1 = new Month(name, number);
    Month month2 = new Month(name2, number2);

    @Test
    void monthValidateTest_Pass() {
        assertTrue(validateUtils.monthValidate(month1));
    }

    @Test
    void monthValidateTest_Fail() {
        assertFalse(validateUtils.monthValidate(month2));
    }
}
