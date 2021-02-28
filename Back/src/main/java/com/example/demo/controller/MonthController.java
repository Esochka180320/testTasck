package com.example.demo.controller;

import com.example.demo.entity.Month;
import com.example.demo.request.UpdateRequest;
import com.example.demo.service.MonthService;
import com.example.demo.utils.ValidateUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MonthController {
    private final MonthService monthService;

    public MonthController( MonthService monthService) {
        this.monthService = monthService;
    }

    @PutMapping  ("/addMonth")
    public ResponseEntity<?> addMonth(@RequestBody @Validated Month data) {
        if (ValidateUtils.monthValidate(data)){
            return ResponseEntity.ok(monthService.addMonth(data));
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping("/findMonth/{name}")
    public ResponseEntity<?> findMonth(@PathVariable @Validated String name) {

        return ResponseEntity.ok( monthService.findMonth(name));
    }

    @PostMapping("/updateMonth")
    public ResponseEntity<?> updateMonth(@RequestBody @Validated UpdateRequest data) {

        return ResponseEntity.ok( monthService.updateMonth(data));
    }

    @GetMapping("/findAllMonth")
    public ResponseEntity<?> findAllMonth() {
        return ResponseEntity.ok( monthService.findAllMonth());
    }

    @DeleteMapping("/deleteMonth/{number}")
    public Integer deleteMonth(@PathVariable @Validated Integer number) {
        monthService.deleteMonth(number);
        return number;
    }
}
