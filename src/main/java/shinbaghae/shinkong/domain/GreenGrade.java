package shinbaghae.shinkong.domain;

public enum GreenGrade {
    SEED("씨앗"),    // Level 1
    SPROUT("새싹"),  // Level 2
    PEA("완두콩"),   // Level 3
    KING("왕두콩");  // Level 4

    private String value;

    GreenGrade(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }

    public String getValue() {
        return value;
    }

}
