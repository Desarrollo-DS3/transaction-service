package com.transaction_service.transaction.infra.sale.output.persistence;

import com.transaction_service.transaction.domain.sale.model.Sale;
import com.transaction_service.transaction.domain.sale.spi.ISalePersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SaleAdapter implements ISalePersistencePort {
    private final ISaleRepository saleRepository;
    private final ISaleMapper saleMapper;

    @Override
    @Transactional
    public void registerSale(Sale sale) {
        SaleEntity saleEntity = saleMapper.toEntity(sale);
        List<SaleItemEntity> saleEntities = saleMapper.toItemEntities(sale.getProducts());
        saleEntities.forEach(saleEntity::addItem);
        saleRepository.save(saleEntity);
    }
}
