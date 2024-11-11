package com.transaction_service.transaction.domain.sale.spi;

import com.transaction_service.transaction.domain.sale.model.Sale;

public interface ISaleNotifyPort {
    void notifyRollback(Sale sale);
}