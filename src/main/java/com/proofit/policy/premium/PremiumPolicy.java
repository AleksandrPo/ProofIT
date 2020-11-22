package com.proofit.policy.premium;

import java.math.BigDecimal;

public interface PremiumPolicy {
    boolean isOneTargetTwoItemsPolicy(com.proofit.policy.model.Policy policy, BigDecimal sumInsuredFire, BigDecimal sumInsuredTheft);
    boolean isFire500Theft102_51Policy(BigDecimal sumInsuredFire, BigDecimal sumInsuredTheft);
}
