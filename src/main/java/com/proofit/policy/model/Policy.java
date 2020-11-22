package com.proofit.policy.model;

import com.proofit.policy.enums.PolicyStatus;

import java.util.Collection;

/**
 * Represents policy object
 * PolicyNumber: e.g. LV20-02-100000-5
 * PolicyStatus: e.g. REGISTERED, APPROVED
 */
public class Policy {
    private String number;
    private PolicyStatus status;
    private Collection<PolicyTarget> policyTargets;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public Collection<PolicyTarget> getPolicyTargets() {
        return policyTargets;
    }

    public void setPolicyTargets(Collection<PolicyTarget> policyTargets) {
        this.policyTargets = policyTargets;
    }
}
