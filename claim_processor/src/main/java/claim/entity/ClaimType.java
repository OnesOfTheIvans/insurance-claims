package claim.entity;

public enum ClaimType {
    MEDICAL("MEDICAL"),
    VEHICLE("VEHICLE"),
    PROPERTY("PROPERTY");

    private final String value;

    ClaimType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ClaimType fromString(String value) {
        for (ClaimType type : ClaimType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ClaimType: " + value);
    }
}
