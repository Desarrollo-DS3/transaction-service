package com.transaction_service.transaction.domain.sale.usecase;

import com.transaction_service.transaction.domain.sale.api.ISaleServicePort;
import com.transaction_service.transaction.domain.sale.model.Sale;
import com.transaction_service.transaction.domain.sale.spi.ISaleNotifyPort;
import com.transaction_service.transaction.domain.sale.spi.ISalePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleUseCase implements ISaleServicePort {
    private final ISalePersistencePort salePersistencePort;
    private final ISaleNotifyPort saleNotifyPort;

    @Override
    public void registerSale(Sale sale) {
        try {
            salePersistencePort.registerSale(sale);
        } catch (Exception e) {
            saleNotifyPort.notifyRollback(sale);
            throw e;
        }
    }
}
