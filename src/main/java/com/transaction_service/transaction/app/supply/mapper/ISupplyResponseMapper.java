package com.transaction_service.transaction.app.supply.mapper;

import com.transaction_service.transaction.app.supply.dto.SupplyRequest;
import com.transaction_service.transaction.domain.supply.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyResponseMapper {
    SupplyRequest toSupplyResponse(Supply supply);
}
