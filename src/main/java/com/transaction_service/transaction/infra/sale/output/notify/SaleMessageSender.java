package com.transaction_service.transaction.infra.sale.output.notify;

import com.transaction_service.transaction.app.sale.dto.SaleRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendRollbackNotification(SaleRequest saleRequest) {
        rabbitTemplate.convertAndSend("queue.purchase_restore_cart", saleRequest);
    }
}
