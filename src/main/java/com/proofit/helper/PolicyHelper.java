package com.proofit.helper;

import com.proofit.policy.enums.PolicyStatus;
import com.proofit.policy.enums.RiskType;
import com.proofit.policy.model.InsuredItem;
import com.proofit.policy.model.Policy;
import com.proofit.policy.model.PolicyTarget;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Policy creation helper
 * Used to create policies in manual testing
 */
public class PolicyHelper {

    public static Policy createPolicy(String policyNumber, PolicyStatus policyStatus, Collection<PolicyTarget> targets) {
        Policy p = new Policy();
        p.setNumber(policyNumber);
        p.setStatus(policyStatus);
        p.setStatus(policyStatus);
        p.setPolicyTargets(targets);
        return p;
    }

    public static PolicyTarget createPolicyTarget(String targetName, Collection<InsuredItem> insuredItems) {
        PolicyTarget target = new PolicyTarget();
        target.setName(targetName);
        target.setInsuredItems(insuredItems);
        return target;
    }

    public static InsuredItem createInsuredItem(String itemName, RiskType riskType, BigDecimal sumInsured) {
        InsuredItem item = new InsuredItem();
        item.setName(itemName);
        item.setRiskType(riskType);
        item.setSumInsured(sumInsured);
        return item;
    }
}
