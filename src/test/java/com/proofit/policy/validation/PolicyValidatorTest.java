package com.proofit.policy.validation;

import com.proofit.policy.model.Policy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;

import static com.proofit.policy.helper.TestHelper.createOneTargetTwoItemsPolicy;
import static org.junit.jupiter.api.Assertions.*;

class PolicyValidatorTest {

    private PolicyValidator policyValidator;
    private Policy policy;

    @BeforeEach
    void setUp() {
        policyValidator = new PolicyValidator();
        policy = createOneTargetTwoItemsPolicy();
    }

    @Test
    void testValidatePass() {
        assertDoesNotThrow(() -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnPolicyNumberNull() {
        policy.setNumber(null);
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnPolicyStatusNull() {
        policy.setStatus(null);
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnPolicyTargetsNull() {
        policy.setPolicyTargets(null);
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnTargetNameNull() {
        policy.getPolicyTargets().forEach(t -> t.setName(null));
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnInsuredItemsNull() {
        policy.getPolicyTargets().forEach(t -> t.setInsuredItems(null));
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnItemNameNull() {
        policy.getPolicyTargets().forEach(t -> t.getInsuredItems().forEach(item -> item.setName(null)));
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnSumInsuredNull() {
        policy.getPolicyTargets().forEach(t -> t.getInsuredItems().forEach(item -> item.setSumInsured(null)));
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }

    @Test
    void testValidateFailOnRiskTypeNull() {
        policy.getPolicyTargets().forEach(t -> t.getInsuredItems().forEach(item -> item.setRiskType(null)));
        assertThrows(ValidationException.class, () -> policyValidator.validate(policy));
    }
}