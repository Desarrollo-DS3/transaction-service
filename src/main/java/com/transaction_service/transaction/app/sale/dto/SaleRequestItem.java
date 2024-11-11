package com.transaction_service.transaction.app.sale.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequestItem implements Serializable {
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}