package com.transaction_service.transaction.app.supply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SupplyRequest {
    private Long userId;
    private Long productId;
    private Integer quantity;
}
