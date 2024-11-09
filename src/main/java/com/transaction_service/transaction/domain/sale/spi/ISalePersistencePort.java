package com.transaction_service.transaction.domain.sale.spi;

import com.transaction_service.transaction.domain.sale.model.Sale;

public interface ISalePersistencePort {

    void registerSale(Sale sale);
}
