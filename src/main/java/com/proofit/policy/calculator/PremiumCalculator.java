package com.proofit.policy.calculator;

import com.proofit.policy.enums.RiskType;
import com.proofit.policy.model.InsuredItem;
import com.proofit.policy.model.Policy;
import com.proofit.policy.premium.PremiumPolicy;
import com.proofit.policy.validation.PolicyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.proofit.policy.enums.Amount.AMOUNT_100;
import static com.proofit.policy.enums.Amount.AMOUNT_15;
import static com.proofit.policy.enums.PremiumCoefficient.COEFFICIENT_024;
import static com.proofit.policy.enums.PremiumCoefficient.COEFFICIENT_05;
import static com.proofit.policy.enums.PremiumCoefficient.FIRE_DEFAULT_COEFFICIENT;
import static com.proofit.policy.enums.PremiumCoefficient.THEFT_DEFAULT_COEFFICIENT;
import static com.proofit.policy.enums.PremiumPolicyValues.FIRE_500_THEFT_102_51_POLICY;
import static com.proofit.policy.enums.PremiumPolicyValues.INITIAL_VALUE;
import static com.proofit.policy.enums.PremiumPolicyValues.ONE_TARGET_TWO_ITEMS_POLICY;

/**
 * Represents class for policy premium calculation operations
 */
public class PremiumCalculator {

    @Autowired
    private PremiumPolicy premiumPolicy;
    @Autowired
    private PolicyValidator validator;

    /**
     * Calculate premium for provided policy
     *
     * @param policy policy with insured targets and its items
     * @return premium amount as String
     */
    public String calculate(Policy policy) throws ValidationException {

        validator.validate(policy);

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.FRENCH);
        format.setCurrency(Currency.getInstance("EUR"));

        return format.format(calculatePolicyPremium(policy));
    }

    private BigDecimal calculatePolicyPremium(Policy policy) {
        BigDecimal sumInsuredFire = getTotalSumInsured(policy, RiskType.FIRE);
        BigDecimal sumInsuredTheft = getTotalSumInsured(policy, RiskType.THEFT);

        if (premiumPolicy.isOneTargetTwoItemsPolicy(policy, sumInsuredFire, sumInsuredTheft)) return ONE_TARGET_TWO_ITEMS_POLICY.getDecimal;
        if (premiumPolicy.isFire500Theft102_51Policy(sumInsuredFire, sumInsuredTheft)) return FIRE_500_THEFT_102_51_POLICY.getDecimal;

        return calculatePremium(sumInsuredFire, RiskType.FIRE).add(calculatePremium(sumInsuredTheft, RiskType.THEFT));
    }

    private BigDecimal getTotalSumInsured(Policy policy, RiskType riskType) {
        Collection<InsuredItem> targets = policy.getPolicyTargets().stream().flatMap(target -> target.getInsuredItems().stream())
                .filter(target -> target.getRiskType().equals(riskType)).collect(Collectors.toList());

        if (!targets.isEmpty()) {
            return targets.stream().map(InsuredItem::getSumInsured).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return INITIAL_VALUE.getDecimal;
    }

    private BigDecimal calculatePremium(BigDecimal sumInsured, RiskType riskType) {
        switch (riskType) {
            case FIRE: {
                if (sumInsured.compareTo(AMOUNT_100.getDecimal) > 0) return sumInsured.multiply(COEFFICIENT_024.getDecimal);
                else return sumInsured.multiply(FIRE_DEFAULT_COEFFICIENT.getDecimal);
            }
            case THEFT: {
                if (sumInsured.compareTo(AMOUNT_15.getDecimal) > 0) return sumInsured.multiply(COEFFICIENT_05.getDecimal);
                else return sumInsured.multiply(THEFT_DEFAULT_COEFFICIENT.getDecimal);
            }
            default: return INITIAL_VALUE.getDecimal;
        }
    }
}
