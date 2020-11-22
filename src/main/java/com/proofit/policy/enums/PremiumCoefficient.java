package com.proofit.policy.enums;

import java.math.BigDecimal;

/**
 * Represents amount of currency
 */
public enum PremiumCoefficient {
    COEFFICIENT_05("0.05"),
    COEFFICIENT_024("0.024"),
    FIRE_DEFAULT_COEFFICIENT("0.014"),
    THEFT_DEFAULT_COEFFICIENT("0.11");

    public final String value;
    public final BigDecimal getDecimal;

    PremiumCoefficient(String value) {
        this.value = value;
        this.getDecimal = new BigDecimal(value);
    }
}
