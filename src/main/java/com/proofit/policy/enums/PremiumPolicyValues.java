package com.proofit.policy.enums;

import java.math.BigDecimal;

/**
 * Enum represents amount of currency for premium policy
 */
public enum PremiumPolicyValues {
    INITIAL_VALUE("0.00"),
    ONE_TARGET_TWO_ITEMS_POLICY("2.28"),
    FIRE_500_THEFT_102_51_POLICY("17.13");

    public final String value;
    public final BigDecimal getDecimal;

    PremiumPolicyValues(String value) {
        this.value = value;
        this.getDecimal = new BigDecimal(value);
    }
}
