package com.transaction_service.transaction.app.sale.handler;

import com.transaction_service.transaction.app.sale.dto.SaleRequest;
import com.transaction_service.transaction.app.sale.mapper.ISaleRequestMapper;
import com.transaction_service.transaction.domain.sale.api.ISaleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleHandler implements ISaleHandler {
    private final ISaleServicePort saleServicePort;
    private final ISaleRequestMapper saleRequestMapper;


    @Override
    public void registerSale(SaleRequest saleRequest) {
        saleServicePort.registerSale(saleRequestMapper.toSale(saleRequest));
    }
}
