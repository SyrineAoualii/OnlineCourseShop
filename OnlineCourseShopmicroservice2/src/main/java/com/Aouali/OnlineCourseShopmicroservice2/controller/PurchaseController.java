package com.Aouali.OnlineCourseShopmicroservice2.controller;

import com.Aouali.OnlineCourseShopmicroservice2.model.Purchase;
import com.Aouali.OnlineCourseShopmicroservice2.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")//pre-path
public class PurchaseController
{
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping ("/save")//api/purchase
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping("/getAll/{userId}")//api/purchase/{userId}
    public ResponseEntity<?> getAllPurchasesOfUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(purchaseService.findAllPurchasesOfUser(userId));
    }
}
