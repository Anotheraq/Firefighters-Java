package app.car;


public enum State {
    FREE ("FREE"),
    BUSY ("BUSY");

    private final String state;
    State(final String s) {
        this.state = s;
    }

    public String getState() {
        return state;
    }
}
