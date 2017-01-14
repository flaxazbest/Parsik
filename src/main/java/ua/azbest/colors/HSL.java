package ua.azbest.colors;

import java.util.Formatter;

public class HSL {
    private int h;
    private double s;
    private double l;

    public HSL(int h, double s, double l) {
        this.h = h;
        this.s = s;
        this.l = l;
    }

    public HSL() {
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

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("HSL [%03d; %02.1f; %02.1f]", h, s*100, l*100));
    }

    public String getTextH() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%03d", h));
    }

    public String getTextS() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%02.1f", s*100));
    }

    public String getTextL() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%02.1f", l*100));
    }
}
