package com.fedsav.homeaccountance.model.dto;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Value
public class PurchaseItemDto {

    private String id;
    @Size(min=3, max = 100)
    @NotEmpty
    private String purchaseItemName;
    private LocalDateTime dateTime;
    @Min(0)
    @NotNull
    private Long cost;

    public PurchaseItemDto(String id, String purchaseItemName, LocalDateTime dateTime, Long cost) {
        this.id = id;
        this.purchaseItemName = purchaseItemName;
        this.dateTime = dateTime;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "PurchaseItemDto{" +
                "id=" + id +
                ", purchaseItemName='" + purchaseItemName + '\'' +
                ", dateTime=" + dateTime +
                ", cost=" + cost +
                '}';
    }
}
