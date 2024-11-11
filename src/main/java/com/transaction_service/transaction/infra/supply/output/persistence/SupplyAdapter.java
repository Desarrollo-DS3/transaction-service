package com.transaction_service.transaction.infra.supply.output.persistence;

import com.transaction_service.transaction.domain.supply.model.Supply;
import com.transaction_service.transaction.domain.supply.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {
    private final ISupplyRepository supplyRepository;
    private final ISupplyMapper supplyMapper;

    @Override
    public void registerSupply(Supply supply) {
        supplyRepository.save(supplyMapper.toEntity(supply));
    }
}
