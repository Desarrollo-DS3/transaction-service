package com.transaction_service.transaction.domain.sale;

import com.transaction_service.transaction.domain.sale.model.Sale;
import com.transaction_service.transaction.domain.sale.spi.ISaleNotifyPort;
import com.transaction_service.transaction.domain.sale.spi.ISalePersistencePort;
import com.transaction_service.transaction.domain.sale.usecase.SaleUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaleUseCaseTest {

    private ISalePersistencePort salePersistencePort;
    private ISaleNotifyPort saleNotifyPort;
    private SaleUseCase saleUseCase;

    @BeforeEach
    void setUp() {
        salePersistencePort = mock(ISalePersistencePort.class);
        saleNotifyPort = mock(ISaleNotifyPort.class);
        saleUseCase = new SaleUseCase(salePersistencePort, saleNotifyPort);
    }

    @Test
    void testRegisterSaleSuccessfully() {
        Sale sale = new Sale(1L, 1001L, new ArrayList<>());

        saleUseCase.registerSale(sale);

        verify(salePersistencePort, times(1)).registerSale(sale);
        verify(saleNotifyPort, never()).notifyRollback(any());
    }

    @Test
    void testRegisterSaleWithException() {
        Sale sale = new Sale(1L, 1001L, new ArrayList<>());
        doThrow(new RuntimeException("Persistence error")).when(salePersistencePort).registerSale(sale);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> saleUseCase.registerSale(sale));

        assertEquals("Persistence error", thrown.getMessage());
        verify(salePersistencePort, times(1)).registerSale(sale);
        verify(saleNotifyPort, times(1)).notifyRollback(sale);
    }
}
