package com.proofit.policy.model;

import com.proofit.policy.enums.RiskType;

import java.math.BigDecimal;

/**
 * Represents insured item of specific policy target
 * Name: e.g. TV
 * SumInsured: Cost that will be covered by insurance
 * RiskType: e.g. FIRE, THEFT
 */
public class InsuredItem {
    private String name;
    private BigDecimal sumInsured;
    private RiskType riskType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }
}
