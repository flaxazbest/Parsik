package ua.azbest.colors;

import java.util.Formatter;

public class HEX extends RGB {
    public HEX() {
        super();
    }

    public HEX(int r, int g, int b) {
        super(r, g, b);
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("HEX [%02X; %02X; %02X]", r, g, b));
    }

    public String toWeb() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("#%02X%02X%02X]", r, g, b));
    }
}
