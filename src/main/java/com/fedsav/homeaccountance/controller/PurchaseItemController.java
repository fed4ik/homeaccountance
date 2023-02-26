package com.fedsav.homeaccountance.controller;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.service.PurchaseItemService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("purchases")
@AllArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class PurchaseItemController {

    private final PurchaseItemService service;

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

    @GetMapping("{id}")
    public PurchaseItemDto getPurchaseItem(@PathVariable String id) {
        return service.getPurchaseItem(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public String createPurchaseItem(@Valid @RequestBody PurchaseItemDto dto) {
        return service.createPurchaseItem(dto);
    }
    @DeleteMapping("{id}")
    public void deletePurchaseItem(@PathVariable String id) {
        service.removePurchaseItem(id);
    }

    @PutMapping
    public void editPurchaseItem(@Valid @RequestBody PurchaseItemDto dto){
        service.getPurchaseItem(dto.getId());
        service.editPurchaseItem(dto);
    }
}
