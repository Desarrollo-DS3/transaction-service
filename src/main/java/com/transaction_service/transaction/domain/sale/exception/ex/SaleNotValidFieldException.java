package com.transaction_service.transaction.domain.sale.exception.ex;

import com.transaction_service.transaction.domain.error.ErrorDetail;

import java.io.Serializable;
import java.util.List;

public class SaleNotValidFieldException extends RuntimeException implements Serializable {
    private final transient List<ErrorDetail> errors;

    public SaleNotValidFieldException(String message, List<ErrorDetail> errors) {
        super(message);
        this.errors = errors;
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }
}
