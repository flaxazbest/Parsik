package ua.azbest.colors;

import java.util.Formatter;

public class HSV {

    private int h;
    private double s;
    private double v;

    public HSV(int h, double s, double v) {
        this.h = h;
        this.s = s;
        this.v = v;
    }

    public HSV() {
        this(0,0,0);
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("HSV [%03d; %03.0f; %03.0f]", h, s*100, v*100));
    }

    public String getTextH() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03d", h));
    }

    public String getTextS() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03.0f", s*100));
    }

    public String getTextV() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03.0f", v*100));
    }
}
