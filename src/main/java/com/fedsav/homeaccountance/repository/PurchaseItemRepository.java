package com.fedsav.homeaccountance.repository;

import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItemEntity, UUID> {
}
