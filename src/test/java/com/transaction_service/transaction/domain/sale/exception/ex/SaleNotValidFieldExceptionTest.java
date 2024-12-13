package com.transaction_service.transaction.domain.sale.exception.ex;

import com.transaction_service.transaction.domain.error.ErrorDetail;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SaleNotValidFieldExceptionTest {

    @Test
    void testConstructorAndGetErrors() {
        ErrorDetail errorDetail = new ErrorDetail("Field 'productId' is invalid", "Invalid field");
        List<ErrorDetail> errors = List.of(errorDetail);

        String expectedMessage = "Sale not valid due to invalid fields";
        SaleNotValidFieldException exception = new SaleNotValidFieldException(expectedMessage, errors);

        assertEquals(expectedMessage, exception.getMessage());

        assertEquals(errors, exception.getErrors());
    }

    @Test
    void testGetErrorsWhenNoErrors() {
        SaleNotValidFieldException exception = new SaleNotValidFieldException("No errors", List.of());

        assertTrue(exception.getErrors().isEmpty(), "Error list should be empty when no errors are passed");
    }
}
