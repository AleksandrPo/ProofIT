package com.proofit.policy.helper;

import com.proofit.policy.enums.PolicyStatus;
import com.proofit.policy.enums.RiskType;
import com.proofit.policy.model.InsuredItem;
import com.proofit.policy.model.Policy;
import com.proofit.policy.model.PolicyTarget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class TestHelper {

    public static Policy createPolicyWithFireAndTheftDefaultCoefficients() {
        Collection<InsuredItem> items = new ArrayList<>();
        items.add(createInsuredItem("TV", RiskType.FIRE, new BigDecimal("90.00")));
        items.add(createInsuredItem("Table", RiskType.THEFT, new BigDecimal("14.00")));

        Collection<PolicyTarget> targets = new ArrayList<>();
        targets.add(createPolicyTarget("Home", items));

        return createPolicy("LV20-02-100000-5", PolicyStatus.APPROVED, targets);
    }

    public static Policy createOneTargetTwoItemsPolicy() {
        Collection<InsuredItem> items = new ArrayList<>();
        items.add(createInsuredItem("TV", RiskType.FIRE, new BigDecimal("100.00")));
        items.add(createInsuredItem("Table", RiskType.THEFT, new BigDecimal("8.00")));

        Collection<PolicyTarget> targets = new ArrayList<>();
        targets.add(createPolicyTarget("Home", items));

        return createPolicy("LV20-02-100000-5", PolicyStatus.APPROVED, targets);
    }

    public static Policy createPolicyFireOver100TheftOver15() {
        Collection<InsuredItem> homeItems = new ArrayList<>();
        homeItems.add(createInsuredItem("TV", RiskType.FIRE, new BigDecimal("250.50")));
        homeItems.add(createInsuredItem("Sofa", RiskType.FIRE, new BigDecimal("50.00")));
        homeItems.add(createInsuredItem("Table", RiskType.FIRE, new BigDecimal("15.50")));
        homeItems.add(createInsuredItem("TV", RiskType.THEFT, new BigDecimal("35.50")));
        homeItems.add(createInsuredItem("Table", RiskType.THEFT, new BigDecimal("28.25")));

        Collection<InsuredItem> officeItems = new ArrayList<>();
        officeItems.add(createInsuredItem("TV", RiskType.FIRE, new BigDecimal("123.00")));
        officeItems.add(createInsuredItem("Sofa", RiskType.THEFT, new BigDecimal("30.00")));

        Collection<PolicyTarget> targets = new ArrayList<>();
        targets.add(createPolicyTarget("Home", homeItems));
        targets.add(createPolicyTarget("Office", officeItems));

        return createPolicy("LV20-02-100000-5", PolicyStatus.APPROVED, targets);
    }

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
