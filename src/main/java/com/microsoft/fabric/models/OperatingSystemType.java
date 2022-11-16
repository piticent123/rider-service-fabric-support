package com.microsoft.fabric.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for OperatingSystemType. */
public final class OperatingSystemType extends ExpandableStringEnum<OperatingSystemType> {
    /** Static value Linux for OperatingSystemType. */
    public static final OperatingSystemType LINUX = fromString("Linux");

    /** Static value Windows for OperatingSystemType. */
    public static final OperatingSystemType WINDOWS = fromString("Windows");

    /**
     * Creates or finds a OperatingSystemType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding OperatingSystemType.
     */
    @JsonCreator
    public static OperatingSystemType fromString(String name) {
        return fromString(name, OperatingSystemType.class);
    }

    /**
     * Gets known OperatingSystemType values.
     *
     * @return known OperatingSystemType values.
     */
    public static Collection<OperatingSystemType> values() {
        return values(OperatingSystemType.class);
    }
}