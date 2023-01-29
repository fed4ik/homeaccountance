package com.fedsav.homeaccountance.service;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import com.fedsav.homeaccountance.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {

    @Autowired
    private PurchaseItemRepository repository;

    @Override
    public List<PurchaseItemDto> getPurchaseItemList() {

        List<PurchaseItemEntity> purchaseItemEntityList = repository.findAll();

        List<PurchaseItemDto> itemDtoList = new LinkedList<>();

        for (PurchaseItemEntity entity: purchaseItemEntityList) {
            PurchaseItemDto itemDto = new PurchaseItemDto(entity.getId(), entity.getName(), entity.getDateTime(), entity.getCost());
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

    @Override
    public String createPurchaseItem(PurchaseItemDto dto) {

        PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity(dto.getDateTime(), dto.getPurchaseItemName(), dto.getCost());
        PurchaseItemEntity purchaseItemEntitySaved = repository.save(purchaseItemEntity);

        return purchaseItemEntitySaved.getId();
    }

    @Override
    public List<PurchaseItemDto> getPurchaseItemListDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    }


    @Override
    public void editPurchaseItem(PurchaseItemDto dto) {

    }

    @Override
    public void removePurchaseItem(UUID id) {

    }
}
