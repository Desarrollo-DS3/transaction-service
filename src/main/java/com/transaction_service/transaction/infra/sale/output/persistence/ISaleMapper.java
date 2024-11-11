package com.transaction_service.transaction.infra.sale.output.persistence;

import com.transaction_service.transaction.domain.sale.model.Sale;
import com.transaction_service.transaction.domain.sale.model.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ISaleMapper {
    Sale toSale(SaleEntity saleEntity);

    @Mapping(target = "date", ignore = true)
    @Mapping(target = "products", ignore = true)
    SaleEntity toEntity(Sale sale);

    SaleItem toDomain(SaleItemEntity saleItemEntity);

    @Mapping(target = "sale", ignore = true)
    SaleItemEntity toEntity(SaleItem saleItem);

    default List<SaleItemEntity> toItemEntities(List<SaleItem> items) {
        return items.stream()
                .map(this::toEntity)
                .toList();
    }
}
