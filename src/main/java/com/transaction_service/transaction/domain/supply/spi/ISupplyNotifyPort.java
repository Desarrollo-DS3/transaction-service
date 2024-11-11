package com.transaction_service.transaction.domain.supply.spi;

import com.transaction_service.transaction.domain.supply.model.Supply;

public interface ISupplyNotifyPort {
    void notifyRollback(Supply supply);
}