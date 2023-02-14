package com.fedsav.homeaccountance.service;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import com.fedsav.homeaccountance.repository.PurchaseItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PurchaseItemServiceImpl implements PurchaseItemService {

    private PurchaseItemRepository repository;

    @Override
    public List<PurchaseItemDto> getPurchaseItemList() {

        List<PurchaseItemEntity> purchaseItemEntityList = repository.findAll();

        return getPurchaseItemDtoList(purchaseItemEntityList);
    }

    @Override
    public String createPurchaseItem(PurchaseItemDto dto) {

        PurchaseItemEntity purchaseItemEntity = PurchaseItemEntity.ofDto(dto);
        PurchaseItemEntity purchaseItemEntitySaved = repository.save(purchaseItemEntity);

        return purchaseItemEntitySaved.getId();
    }

    @Override
    public List<PurchaseItemDto> getPurchaseItemListDateRange(LocalDateTime startDate, LocalDateTime endDate) {

        List<PurchaseItemEntity> purchaseItemEntityList = repository.findAllByDateTimeBetween(startDate, endDate);

        return getPurchaseItemDtoList(purchaseItemEntityList);
    }

    @Override
    public PurchaseItemDto getPurchaseItem(String id) {

        PurchaseItemEntity purchaseItemEntity = repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException("Purchase Item with id was not found: " + id, 1));

        return PurchaseItemDto.ofEntity(purchaseItemEntity);
    }

    @Override
    public void editPurchaseItem(PurchaseItemDto dto) {
        PurchaseItemEntity purchaseItemEntity = PurchaseItemEntity.ofDto(dto);
        repository.save(purchaseItemEntity);
    }

    @Override
    public void removePurchaseItem(String id) {
        repository.deleteById(id);
    }


    private static List<PurchaseItemDto> getPurchaseItemDtoList(List<PurchaseItemEntity> purchaseItemEntityList) {

        return purchaseItemEntityList.stream()
                .map(PurchaseItemDto::ofEntity)
                .collect(Collectors.toList());

    }
}
