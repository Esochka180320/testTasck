package com.example.demo.utils;

import com.example.demo.entity.Month;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ValidateUtils {
    public static boolean monthValidate(Month month){
        System.out.println(validateName(month.getName()));
        System.out.println(validateNumber(month.getNumber()));
        System.out.println(getIndex(month.getName()));
        return validateName(month.getName())
                && validateNumber(month.getNumber())
                && getIndex(month.getName())+1 == month.getNumber();

    }

    private static boolean validateName(String name) {
        Set<String> month = getMonthName();
        return month.contains(name);
    }

    private static boolean validateNumber(Integer number) {
        return number>=1 && number<=12;
    }

    private static Set<String> getMonthName() {
        Set<String> month = new LinkedHashSet<>();
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        return month;
    }

    private static int getIndex(String value) {
        int result = 0;

        for (String entry:getMonthName()) {
            if (entry.equals(value)) return result;
            result++;

        }
        return -1;
    }


}
