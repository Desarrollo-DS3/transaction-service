package com.transaction_service.transaction.domain.sale.api;

import com.transaction_service.transaction.domain.sale.model.Sale;

public interface ISaleServicePort {
    void registerSale(Sale sale);
}
