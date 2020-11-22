package com.proofit.policy.calculator;

import com.proofit.policy.model.Policy;
import com.proofit.policy.premium.PremiumPolicy;
import com.proofit.policy.validation.PolicyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;

import static com.proofit.policy.helper.TestHelper.createOneTargetTwoItemsPolicy;
import static com.proofit.policy.helper.TestHelper.createPolicyFireOver100TheftOver15;
import static com.proofit.policy.helper.TestHelper.createPolicyWithFireAndTheftDefaultCoefficients;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PremiumCalculatorTest {

    @InjectMocks
    private PremiumCalculator calculator;

    @Mock
    PremiumPolicy premiumPolicy;
    @Mock
    PolicyValidator validator;

    @BeforeEach
    void setUp() throws ValidationException {
        doNothing().when(validator).validate(any(Policy.class));
    }

    @Test
    void testCalculateOneTargetTwoItemsPolicy() throws ValidationException {
        when(premiumPolicy.isOneTargetTwoItemsPolicy(any(Policy.class), any(BigDecimal.class), any(BigDecimal.class))).thenReturn(true);
        assertThat(calculator.calculate(createOneTargetTwoItemsPolicy()), is("2,28 EUR"));
    }

    @Test
    void testCalculateFire500Theft102_51Policy() throws ValidationException {
        when(premiumPolicy.isFire500Theft102_51Policy(any(BigDecimal.class), any(BigDecimal.class))).thenReturn(true);
        assertThat(calculator.calculate(createOneTargetTwoItemsPolicy()), is("17,13 EUR"));
    }

    @Test
    void testCalculatePolicyOnFireAndTheftDefaultCoefficient() throws ValidationException {
        assertThat(calculator.calculate(createPolicyWithFireAndTheftDefaultCoefficients()), is("2,80 EUR"));
    }

    @Test
    void testCalculatePolicyOnFireOver100AndTheftOver15() throws ValidationException {
        assertThat(calculator.calculate(createPolicyFireOver100TheftOver15()), is("15,22 EUR"));
    }
}