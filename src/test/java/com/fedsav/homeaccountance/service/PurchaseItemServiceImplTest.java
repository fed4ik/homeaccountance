package com.fedsav.homeaccountance.service;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import com.fedsav.homeaccountance.repository.PurchaseItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseItemServiceImplTest {

    @Mock
    private PurchaseItemRepository repository;

    @InjectMocks
    private PurchaseItemServiceImpl purchaseItemServiceImpl;


    @Test
    void createPurchaseItem() {

        //given
        final String TEST_ID = "123456";
        final String testEntityName = "testEntity";

        PurchaseItemEntity purchaseItemEntity = PurchaseItemEntity.builder()
                .name(testEntityName)
                .build();

        PurchaseItemEntity purchaseItemSavedEntity = PurchaseItemEntity.builder()
                .id(TEST_ID)
                .name(testEntityName)
                .build();

        when(repository.save(purchaseItemEntity)).thenReturn(purchaseItemSavedEntity);
        PurchaseItemDto purchaseItemDto = PurchaseItemDto.ofEntity(purchaseItemEntity);

        //when
        String purchaseItem = purchaseItemServiceImpl.createPurchaseItem(purchaseItemDto);

        //then
        assertThat(purchaseItem, equalTo(TEST_ID));
    }

    @Test
    void getPurchaseItem(){

        //given
        final String TEST_ID = "123456";
        final String testEntityName = "testEntity";

        PurchaseItemEntity purchaseItemReturnedEntity = PurchaseItemEntity.builder()
                .id(TEST_ID)
                .name(testEntityName)
                .build();

        when(repository.findById(TEST_ID)).thenReturn(Optional.ofNullable(purchaseItemReturnedEntity));
        PurchaseItemDto purchaseItemDto = PurchaseItemDto.ofEntity(purchaseItemReturnedEntity);

        PurchaseItemDto purchaseItemDtoService = purchaseItemServiceImpl.getPurchaseItem(TEST_ID);
        //then
        assertThat(purchaseItemDtoService, equalTo(purchaseItemDto));
    }

    @Test
    void getPurchaseItemWithThrowException(){

        final String TEST_ID = "123456";
        String expectedMassage = "Purchase Item with id was not found: " + TEST_ID;

        EmptyResultDataAccessException emptyResultDataAccessException = assertThrows(EmptyResultDataAccessException.class, () -> {
            purchaseItemServiceImpl.getPurchaseItem(TEST_ID);
        });

        assertTrue(emptyResultDataAccessException.getMessage().contains(expectedMassage));

    }

}