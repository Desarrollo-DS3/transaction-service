package com.transaction_service.transaction.domain.supply.api;

import com.transaction_service.transaction.domain.supply.model.Supply;

public interface ISupplyServicePort {
    void registerSupply(Supply supply);
}
