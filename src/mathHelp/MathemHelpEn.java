package mathHelp;

public enum MathemHelpEn {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String stringValue;

    private MathemHelpEn(String value) {
        this.stringValue=value;
    }

    public String getStringValue() {
        return stringValue;
    }
}
