package com.Aouali.OnlineCourseShopmicroservice2.repository;

import com.Aouali.OnlineCourseShopmicroservice2.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    List<Purchase> findAllByUserId(Long userID);
}
