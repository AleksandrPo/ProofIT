package com.proofit.policy.enums;

/**
 * Enum represents error messages
 */
public enum EnumValidationError {
    MANDATORY_DATA_MISSING("Mandatory data is missing!");

    public String value;

    EnumValidationError(String value) {
        this.value = value;
    }
}
