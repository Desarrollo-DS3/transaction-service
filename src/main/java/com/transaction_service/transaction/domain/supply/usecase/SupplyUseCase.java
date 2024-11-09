package com.transaction_service.transaction.domain.supply.usecase;

import com.transaction_service.transaction.domain.supply.api.ISupplyServicePort;
import com.transaction_service.transaction.domain.supply.model.Supply;
import com.transaction_service.transaction.domain.supply.spi.ISupplyNotifyPort;
import com.transaction_service.transaction.domain.supply.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyUseCase implements ISupplyServicePort {
    private final ISupplyPersistencePort supplyPersistencePort;
    private final ISupplyNotifyPort supplyNotifyPort;

    @Override
    public void registerSupply(Supply supply) {
        try {
            supplyPersistencePort.registerSupply(supply);
        } catch (Exception e) {
            supplyNotifyPort.notifyRollback(supply);
            throw e;
        }
    }
}
