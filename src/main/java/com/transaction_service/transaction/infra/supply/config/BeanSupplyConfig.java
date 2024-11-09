package com.transaction_service.transaction.infra.supply.config;

import com.transaction_service.transaction.app.supply.mapper.ISupplyResponseMapper;
import com.transaction_service.transaction.domain.supply.api.ISupplyServicePort;
import com.transaction_service.transaction.domain.supply.spi.ISupplyNotifyPort;
import com.transaction_service.transaction.domain.supply.spi.ISupplyPersistencePort;
import com.transaction_service.transaction.domain.supply.usecase.SupplyUseCase;
import com.transaction_service.transaction.infra.supply.out.notify.SupplyMessageSender;
import com.transaction_service.transaction.infra.supply.out.notify.SupplyNotify;
import com.transaction_service.transaction.infra.supply.out.persistence.ISupplyMapper;
import com.transaction_service.transaction.infra.supply.out.persistence.ISupplyRepository;
import com.transaction_service.transaction.infra.supply.out.persistence.SupplyAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanSupplyConfig {
    private final SupplyMessageSender supplyMessageSender;
    private final ISupplyResponseMapper supplyResponseMapper;
    private final ISupplyRepository supplyRepository;
    private final ISupplyMapper supplyMapper;

    @Bean
    public ISupplyPersistencePort supplyProductPersistence() {
        return new SupplyAdapter(supplyRepository, supplyMapper);
    }

    @Bean
    public ISupplyNotifyPort supplyProductNotify() {
        return new SupplyNotify(supplyMessageSender, supplyResponseMapper);
    }

    @Bean
    public ISupplyServicePort productCreateService() {
        return new SupplyUseCase(supplyProductPersistence(), supplyProductNotify());
    }
}
