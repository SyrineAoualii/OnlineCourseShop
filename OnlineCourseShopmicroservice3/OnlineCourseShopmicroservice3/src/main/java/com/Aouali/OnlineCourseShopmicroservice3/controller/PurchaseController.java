package com.Aouali.OnlineCourseShopmicroservice3.controller;

import com.Aouali.OnlineCourseShopmicroservice3.model.User;
import com.Aouali.OnlineCourseShopmicroservice3.request.PurchaseServiceRequest;
import com.Aouali.OnlineCourseShopmicroservice3.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

/**
 * @author sa
 * @date 10.10.2021
 * @time 13:45
 */
@RestController
@RequestMapping("gateway/purchase")//pre-path
public class PurchaseController
{
    @Autowired
    private PurchaseServiceRequest purchaseServiceRequest;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/save")//gateway/purchase
    public ResponseEntity<?> savePurchase(@RequestBody Object purchase)
    {
        return new ResponseEntity<>(purchaseServiceRequest.savePurchase(purchase), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/getAll/{userId}")//gateway/purchase
    public ResponseEntity<?> getAllPurchasesOfAuthorizedUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(purchaseServiceRequest.getAllPurchasesOfUser(userId));
    }
    }


