package com.transaction_service.transaction.app.sale.handler;

import com.transaction_service.transaction.app.sale.dto.SaleRequest;

public interface ISaleHandler {
    void registerSale(SaleRequest saleRequest);
}
