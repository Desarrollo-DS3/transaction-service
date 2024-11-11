package com.transaction_service.transaction.domain.sale.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SaleItem {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
