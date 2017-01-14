package ua.azbest.colors;

public class ColorConverter {

    public static CMYK RGBtoCMYK(RGB rgb) {
        double r1 = rgb.getR() / 255.0;
        double g1 = rgb.getG() / 255.0;
        double b1 = rgb.getB() / 255.0;
        double max = Math.max(Math.max(r1, g1), b1);
        double k = 1 - max;

        double c = 0;
        double m = 0;
        double y = 0;

        if (k < 1.00) {
            c = (1 - r1 - k) / (1 - k);
            m = (1 - g1 - k) / (1 - k);
            y = (1 - b1 - k) / (1 - k);
        }

        return new CMYK(c, m, y, k);
    }

    public static RGB CMYKtoRGB(CMYK cm) {
        int r = (int) (255 * (1-cm.getC()) * (1-cm.getK()));
        int g = (int) (255 * (1-cm.getM()) * (1-cm.getK()));
        int b = (int) (255 * (1-cm.getY()) * (1-cm.getK()));

        return new RGB (r,g,b);
    }

    public static HEX RGBtoHEX(RGB rgb) {
        return (HEX)rgb;
    }

    public static RGB HEXtoRGB(HEX hex) {
        return hex;
    }

    public static HSL RGBtoHSL(RGB rgb) {
        double r1 = rgb.getR()/255.0;
        double g1 = rgb.getG()/255.0;
        double b1 = rgb.getB()/255.0;
        double Cmax = Math.max(r1,Math.max(g1, b1));
        double Cmin = Math.min(r1, Math.min(g1, b1));
        double d = Cmax - Cmin;

        double h;
        if (d==0) {h=0;}
        else if (Cmax == r1) { h = 60 * ( ((int)((g1 - b1)/d))%6 ); }
        else if (Cmax == g1) { h = 60 * ((b1 - r1)/d+2); }
        else { h = 60 * ((r1 - g1)/d+4); }

        double l = (Cmax + Cmin) / 2;
        double s;
        if ( d == 0 ) s = 0;
        else s = d / (1 - Math.abs(2*l - 1));
        if (l==1.00) l = 0.999;

        return new HSL((int)h, s, l);
    }

    public static RGB HSLtoRGB(HSL hsl) {
        double h = hsl.getH();
        double c = (1 - Math.abs(2*hsl.getL() - 1)) * hsl.getS();
        double tt =  (1 - Math.abs( (h/60)%2 - 1 ) );
        double x = c * tt;
        double m = hsl.getL() - c/2;


        double r=0, g=0, b=0;
        if ( 0 <= h && h < 60 ) { r = c; g = x; b = 0; }
        else if ( 60 <= h && h < 120 ) { r = x; g = c; b = 0; }
        else if ( 120 <= h && h < 180 ) { r = 0; g = c; b = x; }
        else if ( 180 <= h && h < 240 ) { r = 0; g = x; b = c; }
        else if ( 240 <= h && h < 300 ) { r = x; g = 0; b = c; }
        else { r = c; g = 0; b = x; }

        r = (r+m)*255;
        g = (g+m)*255;
        b = (b+m)*255;

        return new RGB( (int)r, (int)g, (int)b );
    }

    public static HSV RGBtoHSV (RGB rgb)
    {
        double r1 = rgb.getR()/255.0;
        double g1 = rgb.getG()/255.0;
        double b1 = rgb.getB()/255.0;
        double Cmax = Math.max(r1,Math.max(g1, b1));
        double Cmin = Math.min(r1, Math.min(g1, b1));
        double d = Cmax - Cmin;

        double h;
        if (d==0) {h=0;}
        else if (Cmax == r1) { h = 60 * ( ((int)((g1 - b1)/d))%6 ); }
        else if (Cmax == g1) { h = 60 * ((b1 - r1)/d+2); }
        else { h = 60 * ((r1 - g1)/d+4); }

        double s;
        if ( Cmax == 0 ) {
            s = 0;
        } else {
            s = d / Cmax;
        }

        return new HSV ((int)h, s, Cmax);
    }

    public static RGB HSVtoRGB(HSV hsv) {
        //*
        double c = hsv.getS() * hsv.getV();
        double x = c * (1 - Math.abs( ((double)hsv.getH()/60)%2 - 1 ) );
        double m = hsv.getV() - c;
        double h = hsv.getH();

        double r=0, g=0, b=0;
        if ( 0 <= h && h < 60 ) { r = c; g = x; b = 0; }
        else if ( 60 <= h && h < 120 ) { r = x; g = c; b = 0; }
        else if ( 120 <= h && h < 180 ) { r = 0; g = c; b = x; }
        else if ( 180 <= h && h < 240 ) { r = 0; g = x; b = c; }
        else if ( 240 <= h && h < 300 ) { r = x; g = 0; b = c; }
        else { r = c; g = 0; b = x; }

        r = (r+m)*255;
        g = (g+m)*255;
        b = (b+m)*255;
        //*/

        return new RGB( (int)r, (int)g, (int)b );
    }

    public static HSV CMYKtoHSV(CMYK cmyk) {
        RGB rgb = ColorConverter.CMYKtoRGB(cmyk);
        return ColorConverter.RGBtoHSV(rgb);
    }

}
