package org.sandboxpowered.sandbox.api.permission;

public enum Permission {
    /**
     * Equal to true
     */
    ALLOW,
    /**
     * Not overridden, addons should use default behaviour
     */
    DEFAULT,
    /**
     * Equal to false
     */
    DENY
}
