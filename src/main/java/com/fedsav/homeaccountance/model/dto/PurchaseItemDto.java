package com.fedsav.homeaccountance.model.dto;

import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Value
@Builder
public class PurchaseItemDto {

    String id;
    @Size(min=3, max = 100)
    @NotEmpty
    String purchaseItemName;
    LocalDateTime dateTime;
    @Min(0)
    @NotNull
    Long cost;

    public static PurchaseItemDto ofEntity(PurchaseItemEntity purchaseItemEntity) {
        return PurchaseItemDto.builder()
                .id(purchaseItemEntity.getId())
                .purchaseItemName(purchaseItemEntity.getName())
                .cost(purchaseItemEntity.getCost())
                .dateTime(purchaseItemEntity.getDateTime())
                .build();
    }
}
