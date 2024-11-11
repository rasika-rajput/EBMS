package com.tka.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Bonus;
import com.tka.service.BonusService;

@RestController
@RequestMapping("/bonus")
public class BonusController 
{

    @Autowired
     BonusService bonusService;

    @PostMapping("/calculateBonus/{employeeId}")
    public void calculateBonus(@PathVariable Long employeeId) 
    {
        bonusService.calculateTotalBonus(employeeId);
    }

    @GetMapping("getBonusByEmployeeId/{employeeId}")
    public List<Bonus> getBonusByEmployeeId(@PathVariable Long employeeId) 
    {
        return bonusService.getBonusByEmployeeId(employeeId);
    }
    
    @GetMapping("/monthlyBonusReport/{startDate}/{endDate}")
    public List<Bonus> bonusReport(@PathVariable Date startDate, @PathVariable Date endDate) 
    {
    	return bonusService.bonusReport(startDate, endDate);
    }

}

