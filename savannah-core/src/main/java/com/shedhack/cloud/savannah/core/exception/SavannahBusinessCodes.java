package com.shedhack.cloud.savannah.core.exception;

import com.shedhack.exception.core.BusinessCode;

/**
 * <pre>
 *     Business Codes which are shared with clients.
 * </pre>
 */
public enum SavannahBusinessCodes implements BusinessCode {

    C001("Organisation name is invalid, no spaces."),
    C002("Organisation cannot be created."),
    C003("Organisation already exists."),
    C004("Organisation cannot be deleted."),
    C010("Service name is invalid, no spaces.");

    private final String description;

    SavannahBusinessCodes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCode() {
        return this.name();
    }
}
