package com.proofit.policy.enums;

import java.math.BigDecimal;

/**
 * Enum represents amount of currency used in comparison and threshold definition
 */
public enum Amount {
    AMOUNT_8("8.00"),
    AMOUNT_15("15.00"),
    AMOUNT_100("100.00"),
    AMOUNT_102_51("102.51"),
    AMOUNT_500("500.00");

    public final String value;
    public final BigDecimal getDecimal;

    Amount(String value) {
        this.value = value;
        this.getDecimal = new BigDecimal(value);
    }
}
