package com.transaction_service.transaction.app.sale.mapper;

import com.transaction_service.transaction.app.sale.dto.SaleRequest;
import com.transaction_service.transaction.domain.sale.model.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISaleResponseMapper {
    SaleRequest toSaleResponse(Sale sale);
}
