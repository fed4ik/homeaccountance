package com.fedsav.homeaccountance.controller;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseItemController {

    @Autowired
    private PurchaseItemService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/purchases")
    public List<PurchaseItemDto> getAllPurchases() {
        return service.getPurchaseItemList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/purchase")
    public String createPurchaseItem(@RequestBody PurchaseItemDto dto) {
        return service.createPurchaseItem(dto);
    }

}
