package ua.azbest.colors;

import java.util.Formatter;

public class CMYK {

    private double n1;
    private double n2;
    private double n3;
    private double n4;

    public CMYK(double n1, double n2, double n3, double n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public CMYK() {
        this(0.0, 0.0, 0.0, 0.0);
    }

    @Override
    public String toString() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("CMYK [%.2f; %.2f; %.2f; %.2f]", n1, n2, n3, n4));
    }

    public double getC() {
        return n1;
    }

    public void setC(double n1) {
        this.n1 = n1;
    }

    public double getM() {
        return n2;
    }

    public void setM(double n2) {
        this.n2 = n2;
    }

    public double getY() {
        return n3;
    }

    public void setY(double n3) {
        this.n3 = n3;
    }

    public double getK() {
        return n4;
    }

    public void setK(double n4) {
        this.n4 = n4;
    }

    public String getTextC() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%.2f", n1));
    }

    public String getTextM() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%.2f", n2));
    }

    public String getTextY() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%.2f", n3));
    }

    public String getTextK() {
        Formatter f = new Formatter();
        return String.valueOf(f.format("%.2f", n4));
    }
}
