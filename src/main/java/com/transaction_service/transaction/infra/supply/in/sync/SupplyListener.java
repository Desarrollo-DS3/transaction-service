package com.transaction_service.transaction.infra.supply.in.sync;

import com.transaction_service.transaction.app.supply.dto.SupplyRequest;
import com.transaction_service.transaction.app.supply.handler.ISupplyHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@Validated
public class SupplyListener {
    private final ISupplyHandler supplyHandler;

    public SupplyListener(ISupplyHandler supplyHandler) {
        this.supplyHandler = supplyHandler;
    }

    @RabbitListener(queues = "supply_add_transc")
    public void notifyRegisterTransaction(SupplyRequest supplyRequest) {
        supplyHandler.registerSupply(supplyRequest);
    }
}
