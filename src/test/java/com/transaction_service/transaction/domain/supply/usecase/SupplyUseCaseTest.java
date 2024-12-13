package com.transaction_service.transaction.domain.supply.usecase;

import com.transaction_service.transaction.domain.supply.model.Supply;
import com.transaction_service.transaction.domain.supply.spi.ISupplyNotifyPort;
import com.transaction_service.transaction.domain.supply.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class SupplyUseCaseTest {

    @Test
    void testRegisterSupplyWhenNoException() {
        ISupplyPersistencePort supplyPersistencePort = mock(ISupplyPersistencePort.class);
        ISupplyNotifyPort supplyNotifyPort = mock(ISupplyNotifyPort.class);

        SupplyUseCase supplyUseCase = new SupplyUseCase(supplyPersistencePort, supplyNotifyPort);

        Long id = 1L;
        Long userId = 100L;
        Long productId = 200L;
        Integer quantity = 10;
        Supply supply = new Supply(id, userId, productId, quantity);

        supplyUseCase.registerSupply(supply);

        verify(supplyPersistencePort).registerSupply(supply);
        verify(supplyNotifyPort, never()).notifyRollback(any());
    }

    @Test
    void testRegisterSupplyWhenExceptionOccurs() {
        ISupplyPersistencePort supplyPersistencePort = mock(ISupplyPersistencePort.class);
        ISupplyNotifyPort supplyNotifyPort = mock(ISupplyNotifyPort.class);

        SupplyUseCase supplyUseCase = new SupplyUseCase(supplyPersistencePort, supplyNotifyPort);

        Long id = 1L;
        Long userId = 100L;
        Long productId = 200L;
        Integer quantity = 10;
        Supply supply = new Supply(id, userId, productId, quantity);

        doThrow(new RuntimeException("Persistencia fallida")).when(supplyPersistencePort).registerSupply(supply);

        supplyUseCase.registerSupply(supply);

        verify(supplyNotifyPort).notifyRollback(supply);
    }
}
