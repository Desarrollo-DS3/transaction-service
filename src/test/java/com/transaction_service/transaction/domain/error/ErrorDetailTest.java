package com.transaction_service.transaction.domain.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDetailTest {

    @Test
    void testGettersAndSetters() {
        ErrorDetail errorDetail = new ErrorDetail("field1", "message1");

        assertEquals("field1", errorDetail.getField());
        assertEquals("message1", errorDetail.getMessage());

        errorDetail.setField("newField");
        errorDetail.setMessage("newMessage");

        assertEquals("newField", errorDetail.getField());
        assertEquals("newMessage", errorDetail.getMessage());
    }

    @Test
    void testEqualsAndHashCodeWithEqualObjects() {
        ErrorDetail errorDetail1 = new ErrorDetail("field1", "message1");
        ErrorDetail errorDetail2 = new ErrorDetail("field1", "message1");

        assertEquals(errorDetail1, errorDetail2);
        assertEquals(errorDetail1.hashCode(), errorDetail2.hashCode());
    }

    @Test
    void testEqualsWithDifferentObjects() {
        ErrorDetail errorDetail1 = new ErrorDetail("field1", "message1");
        ErrorDetail errorDetail2 = new ErrorDetail("field2", "message2");

        assertNotEquals(errorDetail1, errorDetail2);
    }

    @Test
    void testEqualsWithNullObject() {
        ErrorDetail errorDetail = new ErrorDetail("field1", "message1");

        assertNotEquals(errorDetail, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        ErrorDetail errorDetail = new ErrorDetail("field1", "message1");

        assertNotEquals(errorDetail, "Some String");
    }

    @Test
    void testHashCodeWithDifferentObjects() {
        ErrorDetail errorDetail1 = new ErrorDetail("field1", "message1");
        ErrorDetail errorDetail2 = new ErrorDetail("field2", "message2");

        assertNotEquals(errorDetail1.hashCode(), errorDetail2.hashCode());
    }
}
