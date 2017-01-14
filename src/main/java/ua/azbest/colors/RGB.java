package ua.azbest.colors;

import java.util.Formatter;

public class RGB {

    protected int r;
    protected int g;
    protected int b;

    public RGB(int n1, int n2, int n3) {
        this.r = n1;
        this.g = n2;
        this.b = n3;
    }

    public RGB() {
        this(0,0,0);
    }

    public int getR() {
        return r;
    }

    public void setR(int n1) {
        this.r = n1;
    }

    public int getG() {
        return g;
    }

    public void setG(int n2) {
        this.g = n2;
    }

    public int getB() {
        return b;
    }

    public void setB(int n3) {
        this.b = n3;
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("RGB [%03d; %03d; %03d]", r, g, b));
    }

    public String getTextR() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03d", r));
    }

    public String getTextG() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03d", g));
    }

    public String getTextB() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03d", b));
    }

    public String toWeb() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("#%02X%02X%02X", r, g, b));
    }
}
