package com.transaction_service.transaction.app.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SaleRequestItem {
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
