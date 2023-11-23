package com.Aouali.OnlineCourseShopmicroservice2.service;

import com.Aouali.OnlineCourseShopmicroservice2.model.Purchase;

import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(Purchase purchase);

    List<Purchase> findAllPurchasesOfUser(Long userId);
}
