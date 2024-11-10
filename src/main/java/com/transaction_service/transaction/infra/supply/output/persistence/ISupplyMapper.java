package com.transaction_service.transaction.infra.supply.output.persistence;

import com.transaction_service.transaction.domain.supply.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    SupplyEntity toEntity(Supply supply);
}
