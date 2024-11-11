package com.transaction_service.transaction.app.supply.handler;

import com.transaction_service.transaction.app.supply.dto.SupplyRequest;
import com.transaction_service.transaction.app.supply.mapper.ISupplyRequestMapper;
import com.transaction_service.transaction.domain.supply.api.ISupplyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyHandler implements ISupplyHandler {
    private final ISupplyServicePort supplyServicePort;
    private final ISupplyRequestMapper supplyRequestMapper;

    @Override
    public void registerSupply(SupplyRequest supplyRequest) {
        supplyServicePort.registerSupply(supplyRequestMapper.toSupply(supplyRequest));
    }
}
