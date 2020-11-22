package com.proofit.policy.validation;

import com.proofit.policy.enums.EnumValidationError;
import com.proofit.policy.model.InsuredItem;
import com.proofit.policy.model.Policy;
import com.proofit.policy.model.PolicyTarget;

import javax.xml.bind.ValidationException;
import java.util.Collection;

/**
 * Represents policy validator
 */
public class PolicyValidator {

    /**
     * Validate passed policy object
     *
     * @param policy policy to validate
     * @throws ValidationException in some of policy fields is null or empty
     */
    public void validate(Policy policy) throws ValidationException {
        if (!isPolicyValid(policy)) throw new ValidationException(EnumValidationError.MANDATORY_DATA_MISSING.value);
    }

    private boolean isPolicyValid(Policy policy) {
        return policy != null
                && !isEmpty(policy.getNumber())
                && policy.getStatus() != null
                && isPolicyTargetsValid(policy.getPolicyTargets());
    }

    private boolean isPolicyTargetsValid(Collection<PolicyTarget> policyTargets) {
        return policyTargets != null && policyTargets.stream()
                .allMatch(pt -> !isEmpty(pt.getName()) && isInsuredItemsValid(pt.getInsuredItems()));
    }

    private boolean isInsuredItemsValid(Collection<InsuredItem> insuredItems) {
        return insuredItems != null
                && insuredItems.stream().allMatch(item ->
                    !isEmpty(item.getName()) && item.getRiskType() != null && item.getSumInsured() != null);
    }

    private boolean isEmpty(String str) {
        return !(str != null && !str.isEmpty());
    }
}
