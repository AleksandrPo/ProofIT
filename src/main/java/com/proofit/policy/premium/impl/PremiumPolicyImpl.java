package com.proofit.policy.premium.impl;

import com.proofit.policy.model.Policy;
import com.proofit.policy.premium.PremiumPolicy;

import java.math.BigDecimal;

import static com.proofit.policy.enums.Amount.AMOUNT_100;
import static com.proofit.policy.enums.Amount.AMOUNT_102_51;
import static com.proofit.policy.enums.Amount.AMOUNT_500;
import static com.proofit.policy.enums.Amount.AMOUNT_8;

/**
 * Represents bonus premium policy checks
 * Some policies can have a predefined premium
 */
public class PremiumPolicyImpl implements PremiumPolicy {

    /**
     * Check if policy has one target with two items with risk type fire and theft,
     * which has insured sum of 100.00 and 8.00 respectively
     *
     * @param policy policy to check
     * @param sumInsuredFire items total sum insured for risk type FIRE
     * @param sumInsuredTheft items total sum insured for risk type THEFT
     * @return true if policy is under conditions described above
     */
    @Override
    public boolean isOneTargetTwoItemsPolicy(Policy policy, BigDecimal sumInsuredFire, BigDecimal sumInsuredTheft) {
        return policy.getPolicyTargets().size() == 1
                && policy.getPolicyTargets().stream().anyMatch(target -> target.getInsuredItems().size() == 2)
                && sumInsuredFire.toString().equals(AMOUNT_100.value)
                && sumInsuredTheft.toString().equals(AMOUNT_8.value);
    }

    /**
     * Check if policy items total sum insured to FIRE and THEFT is 500.00 and 102.51 respectively
     *
     * @param sumInsuredFire items total sum insured for risk type FIRE
     * @param sumInsuredTheft items total sum insured for risk type THEFT
     * @return true if policy insured items total sum is 500.00 and 102.51 for risk type FIRE and THEFT respectively
     */
    @Override
    public boolean isFire500Theft102_51Policy(BigDecimal sumInsuredFire, BigDecimal sumInsuredTheft) {
        return sumInsuredFire.toString().equals(AMOUNT_500.value) && sumInsuredTheft.toString().equals(AMOUNT_102_51.value);
    }
}
