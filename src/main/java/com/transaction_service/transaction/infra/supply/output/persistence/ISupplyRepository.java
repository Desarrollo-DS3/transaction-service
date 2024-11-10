package com.transaction_service.transaction.infra.supply.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

}
