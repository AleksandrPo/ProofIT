package com.proofit.policy.premium.impl;

import com.proofit.policy.model.Policy;
import com.proofit.policy.premium.PremiumPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.proofit.policy.enums.Amount.*;
import static com.proofit.policy.enums.PremiumPolicyValues.INITIAL_VALUE;
import static com.proofit.policy.helper.TestHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PremiumPolicyImplTest {

    private PremiumPolicy premiumPolicy;
    private Policy policy;

    @BeforeEach
    void setUp() {
        premiumPolicy = new PremiumPolicyImpl();
        policy = createOneTargetTwoItemsPolicy();
    }

    @Test
    void testIsOneTargetTwoItemsPolicy() {
        boolean actual = premiumPolicy.isOneTargetTwoItemsPolicy(policy, AMOUNT_100.getDecimal, AMOUNT_8.getDecimal);
        assertThat(actual, is(true));
    }

    @Test
    void testIsOneTargetTwoItemsPolicyIsFalse() {
        boolean actual = premiumPolicy.isOneTargetTwoItemsPolicy(policy, AMOUNT_100.getDecimal, INITIAL_VALUE.getDecimal);
        assertThat(actual, is(false));
    }

    @Test
    void testIsFire500Theft102_51Policy() {
        boolean actual = premiumPolicy.isFire500Theft102_51Policy(AMOUNT_500.getDecimal, AMOUNT_102_51.getDecimal);
        assertThat(actual, is(true));
    }

    @Test
    void testIsFire500Theft102_51PolicyIsFalse() {
        boolean actual = premiumPolicy.isFire500Theft102_51Policy(AMOUNT_500.getDecimal, INITIAL_VALUE.getDecimal);
        assertThat(actual, is(false));
    }

}