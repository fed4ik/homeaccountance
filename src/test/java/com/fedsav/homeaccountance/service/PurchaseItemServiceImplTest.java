package com.fedsav.homeaccountance.service;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.model.entity.PurchaseItemEntity;
import com.fedsav.homeaccountance.repository.PurchaseItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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

        //when
        when(repository.save(purchaseItemEntity)).thenReturn(purchaseItemSavedEntity);

        //then
        assertThat(purchaseItemServiceImpl.createPurchaseItem(PurchaseItemDto.ofEntity(purchaseItemEntity)), equalTo(TEST_ID));
    }

}