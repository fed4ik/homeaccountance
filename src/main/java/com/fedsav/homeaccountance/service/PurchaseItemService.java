package com.fedsav.homeaccountance.service;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PurchaseItemService {
    List<PurchaseItemDto> getPurchaseItemList();
    List<PurchaseItemDto> getPurchaseItemListDateRange(LocalDateTime startDate, LocalDateTime endDate);
    String createPurchaseItem(PurchaseItemDto dto);
    void editPurchaseItem(PurchaseItemDto dto);
    void removePurchaseItem(UUID id);

}
