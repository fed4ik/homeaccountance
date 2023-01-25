package com.fedsav.homeaccountance;

import java.util.UUID;

public class PurchaseItemEntity {
    private UUID id;
    private String name;
    private long cost;

    public PurchaseItemEntity(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
