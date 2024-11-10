package com.transaction_service.transaction.infra.sale.output.notify;

import com.transaction_service.transaction.app.sale.mapper.ISaleResponseMapper;
import com.transaction_service.transaction.domain.sale.model.Sale;
import com.transaction_service.transaction.domain.sale.spi.ISaleNotifyPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleNotify implements ISaleNotifyPort {
    private final SaleMessageSender saleMessageSender;
    private final ISaleResponseMapper saleResponseMapper;

    @Override
    public void notifyRollback(Sale sale) {
        saleMessageSender.sendRollbackNotification(saleResponseMapper.toSaleResponse(sale));
    }
}
