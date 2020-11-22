package com.proofit.policy.model;

import java.util.Collection;

/**
 * Represents target of insurance
 * Name: e.g. A House
 */
public class PolicyTarget {
    private String name;
    private Collection<InsuredItem> insuredItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<InsuredItem> getInsuredItems() {
        return insuredItems;
    }

    public void setInsuredItems(Collection<InsuredItem> insuredItems) {
        this.insuredItems = insuredItems;
    }
}
