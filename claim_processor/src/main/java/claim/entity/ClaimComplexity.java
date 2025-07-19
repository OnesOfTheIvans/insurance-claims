package claim.entity;

public enum ClaimComplexity {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");

    private final String value;

    ClaimComplexity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static ClaimComplexity fromString(String value) {
        for (ClaimComplexity complexity : ClaimComplexity.values()) {
            if (complexity.value.equalsIgnoreCase(value)) {
                return complexity;
            }
        }
        throw new IllegalArgumentException("Invalid ClaimComplexity: " + value);
    }
}
