package com.transaction_service.transaction.infra.sale.in.sync;

import com.transaction_service.transaction.app.sale.dto.SaleRequest;
import com.transaction_service.transaction.app.sale.handler.ISaleHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
public class SaleListener {
    private final ISaleHandler saleHandler;

    public SaleListener(ISaleHandler saleHandler) {
        this.saleHandler = saleHandler;
    }

    @RabbitListener(queues = "purchase_register_transaction")
    public void notifyRegisterTransaction(SaleRequest sale) {
        saleHandler.registerSale(sale);
    }
}
