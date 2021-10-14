package com.latha.creditservice.controller;

import com.latha.creditservice.dao.CreditRepository;
import com.latha.creditservice.exception.EmptyInputException;
import com.latha.creditservice.model.CreditRecord;
import com.latha.creditservice.model.CreditRecordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@RestController
@RequestMapping("/credit")
public class CreditController {


    @Autowired
    public CreditRepository creditService;

    @PostMapping("/addRecord")
    public CreditRecordResponse addRecord(@RequestBody CreditRecord user) {
        CreditRecordResponse response = new CreditRecordResponse();
        if (user.getPanNumber().isEmpty()) {
            throw new EmptyInputException("Cannot add record. Pan number is empty");
        } else {
            creditService.save(user);
            response.setCreditRecord(user);
        }
        return response;
    }

    @GetMapping("/getAllRecords")
    public List<CreditRecord> getAll() {
        return (List<CreditRecord>) creditService.findAll();
    }


    @GetMapping("/getCreditScore/{panNumber}")
    public int getCreditSore(@PathVariable String panNumber) {
        Optional<CreditRecord> record = creditService.findById(panNumber);
        if (record.isPresent()) {
            return record.get().getCreditScore();
        }
        return 0;
    }

}





