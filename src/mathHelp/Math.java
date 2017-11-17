package mathHelp;

public enum Math{
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String stringValue;

    private Math(String value) {
        this.stringValue=value;
    }

    public String getStringValue() {
        return stringValue;
    }
}
