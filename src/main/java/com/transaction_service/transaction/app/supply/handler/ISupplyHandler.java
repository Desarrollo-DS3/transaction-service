package com.transaction_service.transaction.app.supply.handler;

import com.transaction_service.transaction.app.supply.dto.SupplyRequest;

public interface ISupplyHandler {
    void registerSupply(SupplyRequest supplyRequest);
}
