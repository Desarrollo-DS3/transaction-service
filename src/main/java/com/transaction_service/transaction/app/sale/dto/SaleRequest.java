package com.transaction_service.transaction.app.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SaleRequest {
    private Long userId;
    private List<SaleRequestItem> products;
}
