package com.transaction_service.transaction.infra.sale.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<SaleEntity, Long> {

}
