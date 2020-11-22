package com.proofit.controller;

import com.proofit.policy.calculator.PremiumCalculator;
import com.proofit.policy.enums.PolicyStatus;
import com.proofit.policy.enums.RiskType;
import com.proofit.policy.model.Policy;
import com.proofit.policy.model.PolicyTarget;
import com.proofit.policy.model.InsuredItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static com.proofit.helper.PolicyHelper.createInsuredItem;
import static com.proofit.helper.PolicyHelper.createPolicy;
import static com.proofit.helper.PolicyHelper.createPolicyTarget;

/**
 * Policy creation helper
 * Used to create policies in manual testing
 */
@Controller
public class PolicyController implements CommandLineRunner {

    @Autowired
    PremiumCalculator premiumCalculator;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Result: " + premiumCalculator.calculate(getPolicy()));
    }

    private Policy getPolicy() {
        Collection<InsuredItem> items = new ArrayList<>();
        items.add(createInsuredItem("TV", RiskType.FIRE, new BigDecimal("100.00")));
        items.add(createInsuredItem("Table", RiskType.THEFT, new BigDecimal("8.00")));

        Collection<PolicyTarget> targets = new ArrayList<>();
        targets.add(createPolicyTarget("Home", items));

        return createPolicy("LV20-02-100000-5", PolicyStatus.APPROVED, targets);
    }
}
