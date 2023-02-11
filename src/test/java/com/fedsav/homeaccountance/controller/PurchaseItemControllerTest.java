package com.fedsav.homeaccountance.controller;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import com.fedsav.homeaccountance.service.PurchaseItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PurchaseItemController.class)
class PurchaseItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PurchaseItemService service;


    @Test
    void getPurchaseItem() throws Exception {

        //given
        String TEST_ID = "123456";
        String testName = "testName";
        long testCost = 123L;

        PurchaseItemDto testDto = PurchaseItemDto.builder()
                .id(TEST_ID)
                .name(testName)
                .cost(testCost)
                .build();

        //when
        when(service.getPurchaseItem(TEST_ID)).thenReturn(testDto);

        //then
        this.mockMvc
                .perform(get("/purchases/{id}", TEST_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.cost").value(testCost))
                .andExpect(jsonPath("$.name").value(testName))
                .andExpect(jsonPath("$.id").value(TEST_ID));
    }
}