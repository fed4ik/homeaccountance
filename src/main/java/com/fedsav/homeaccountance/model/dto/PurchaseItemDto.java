package com.fedsav.homeaccountance.model.dto;

import java.time.LocalDateTime;

public class PurchaseItemDto {

    private String id;
    private String purchaseItemName;
    private LocalDateTime dateTime;
    private Long cost;


    public PurchaseItemDto() {
    }

    public PurchaseItemDto(String id, String purchaseItemName, LocalDateTime dateTime, Long cost) {
        this.id = id;
        this.purchaseItemName = purchaseItemName;
        this.dateTime = dateTime;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPurchaseItemName() {
        return purchaseItemName;
    }

    public void setPurchaseItemName(String purchaseItemName) {
        this.purchaseItemName = purchaseItemName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
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
