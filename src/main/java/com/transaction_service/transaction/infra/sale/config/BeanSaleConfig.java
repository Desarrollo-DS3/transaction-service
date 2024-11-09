package com.transaction_service.transaction.infra.sale.config;

import com.transaction_service.transaction.app.sale.mapper.ISaleResponseMapper;
import com.transaction_service.transaction.domain.sale.api.ISaleServicePort;
import com.transaction_service.transaction.domain.sale.spi.ISaleNotifyPort;
import com.transaction_service.transaction.domain.sale.spi.ISalePersistencePort;
import com.transaction_service.transaction.domain.sale.usecase.SaleUseCase;
import com.transaction_service.transaction.infra.sale.out.notify.SaleMessageSender;
import com.transaction_service.transaction.infra.sale.out.notify.SaleNotify;
import com.transaction_service.transaction.infra.sale.out.persistence.ISaleMapper;
import com.transaction_service.transaction.infra.sale.out.persistence.ISaleRepository;
import com.transaction_service.transaction.infra.sale.out.persistence.SaleAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanSaleConfig {
    private final SaleMessageSender saleMessageSender;
    private final ISaleResponseMapper saleResponseMapper;
    private final ISaleRepository saleRepository;
    private final ISaleMapper saleMapper;

    @Bean
    public ISalePersistencePort saleProductPersistence() {
        return new SaleAdapter(saleRepository, saleMapper);
    }

    @Bean
    public ISaleNotifyPort saleProductNotify() {
        return new SaleNotify(saleMessageSender, saleResponseMapper);
    }

    @Bean
    public ISaleServicePort saleProductCreateService() {
        return new SaleUseCase(saleProductPersistence(), saleProductNotify());
    }
}
