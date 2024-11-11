package com.transaction_service.transaction.domain.supply.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Supply {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
}
