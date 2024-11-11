package com.transaction_service.transaction.infra.supply.output.notify;

import com.transaction_service.transaction.app.supply.mapper.ISupplyResponseMapper;
import com.transaction_service.transaction.domain.supply.model.Supply;
import com.transaction_service.transaction.domain.supply.spi.ISupplyNotifyPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyNotify implements ISupplyNotifyPort {
    private final SupplyMessageSender supplyMessageSender;
    private final ISupplyResponseMapper supplyResponseMapper;

    @Override
    public void notifyRollback(Supply supply) {
        supplyMessageSender.sendRollbackNotification(supplyResponseMapper.toSupplyResponse(supply));
    }
}
