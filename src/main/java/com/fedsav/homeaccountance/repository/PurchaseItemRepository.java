package com.fedsav.homeaccountance.repository;

import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItemEntity, String> {
    List<PurchaseItemEntity> findAllByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
