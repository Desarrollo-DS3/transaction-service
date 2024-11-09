package com.transaction_service.transaction.app.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequest implements Serializable {
    private Long userId;
    private List<SaleRequestItem> products;
}
