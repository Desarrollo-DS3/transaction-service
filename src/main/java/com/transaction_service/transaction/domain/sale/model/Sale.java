package com.transaction_service.transaction.domain.sale.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Sale {
    private Long id;
    private Long userId;
    private List<SaleItem> products;
}
