package com.transaction_service.transaction.domain.sale.exception;

public class SaleExceptionMessage {
    private SaleExceptionMessage() {
        throw new AssertionError();
    }

    public static final String EMPTY_PRODUCTS =
            "The 'products' field is empty";

    public static final String EMPTY_USER_ID =
            "The 'userId' field is empty";

    public static final String EMPTY_PRODUCT_ID =
            "The 'productId' field is empty";

    public static final String EMPTY_QUANTITY =
            "The 'quantity' field is empty";

    public static final String EMPTY_PRICE =
            "The 'price' field is empty";
}
