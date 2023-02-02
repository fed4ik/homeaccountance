package com.fedsav.homeaccountance.controller;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("purchases")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PurchaseItemDto> getAllPurchases(@RequestParam(required = false)
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                     LocalDateTime startDate,
                                                 @RequestParam(required = false)
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                 LocalDateTime endDate) {
        if(startDate != null && endDate != null){
            return service.getPurchaseItemListDateRange(startDate, endDate);
        }

        return service.getPurchaseItemList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String createPurchaseItem(@RequestBody PurchaseItemDto dto) {
        return service.createPurchaseItem(dto);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    public void deletePurchaseItem(@PathVariable String id) {
        service.removePurchaseItem(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public void editPurchaseItem(@RequestBody PurchaseItemDto dto){
        service.editPurchaseItem(dto);
    }
}
