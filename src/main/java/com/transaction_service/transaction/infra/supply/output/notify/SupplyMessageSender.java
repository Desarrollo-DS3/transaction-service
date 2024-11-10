package com.transaction_service.transaction.infra.supply.output.notify;

import com.transaction_service.transaction.app.supply.dto.SupplyRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyMessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRollbackNotification(SupplyRequest supplyRequest) {
        rabbitTemplate.convertAndSend("supply_restore_stock", supplyRequest);
    }
}
