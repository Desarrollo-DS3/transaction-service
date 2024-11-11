package com.transaction_service.transaction.app.sale.mapper;

import com.transaction_service.transaction.app.sale.dto.SaleRequest;
import com.transaction_service.transaction.app.sale.dto.SaleRequestItem;
import com.transaction_service.transaction.domain.sale.model.Sale;
import com.transaction_service.transaction.domain.sale.model.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISaleRequestMapper {
    @Mapping(target = "id", ignore = true)
    Sale toSale(SaleRequest saleRequest);

    @Mapping(target = "id", ignore = true)
    SaleItem toSaleItem(SaleRequestItem saleRequestItem);

}
