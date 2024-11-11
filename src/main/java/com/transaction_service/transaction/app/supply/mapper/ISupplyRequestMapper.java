package com.transaction_service.transaction.app.supply.mapper;

import com.transaction_service.transaction.app.supply.dto.SupplyRequest;
import com.transaction_service.transaction.domain.supply.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyRequestMapper {
    @Mapping(target = "id", ignore = true)
    Supply toSupply(SupplyRequest supplyRequest);
}
