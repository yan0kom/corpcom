package yan0kom.corpcom.domain.model;

public enum ContactType {
    PHONE("phone"), EMAIL("email");

    private final String code;

    ContactType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ContactType fromCode(String code) {
        return switch (code) {
            case "phone" -> ContactType.PHONE;
            case "email" -> ContactType.EMAIL;
            default -> throw new IllegalArgumentException();
        };
    }
}
