package ua.azbest.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ua.azbest.colors.*;

public class MainController {

    private RGB rgb;
    private CMYK cmyk;
    private HSV hsv;
    private HSL hsl;

    private void setListenerRGB() {
        sliderR.valueProperty().addListener(slideRGB);
        sliderG.valueProperty().addListener(slideRGB);
        sliderB.valueProperty().addListener(slideRGB);
    }

    private void unsetListenerRGB() {
        sliderR.valueProperty().removeListener(slideRGB);
        sliderG.valueProperty().removeListener(slideRGB);
        sliderB.valueProperty().removeListener(slideRGB);
    }

    private void setListenerCMYK() {
        sliderC.valueProperty().addListener(slideCMYK);
        sliderM.valueProperty().addListener(slideCMYK);
        sliderY.valueProperty().addListener(slideCMYK);
        sliderK.valueProperty().addListener(slideCMYK);
    }

    private void unsetListenerCMYK() {
        sliderC.valueProperty().removeListener(slideCMYK);
        sliderM.valueProperty().removeListener(slideCMYK);
        sliderY.valueProperty().removeListener(slideCMYK);
        sliderK.valueProperty().removeListener(slideCMYK);
    }

    private void setListenerHSV() {
        sliderH.valueProperty().addListener(slideHSV);
        sliderS.valueProperty().addListener(slideHSV);
        sliderV.valueProperty().addListener(slideHSV);
    }

    private void unsetListenerHSV() {
        sliderH.valueProperty().removeListener(slideHSV);
        sliderS.valueProperty().removeListener(slideHSV);
        sliderV.valueProperty().removeListener(slideHSV);
    }

    private void setListenerHSL() {
        sliderH1.valueProperty().addListener(slideHSL);
        sliderS1.valueProperty().addListener(slideHSL);
        sliderL.valueProperty().addListener(slideHSL);
    }

    private void unsetListenerHSL() {
        sliderH1.valueProperty().removeListener(slideHSL);
        sliderS1.valueProperty().removeListener(slideHSL);
        sliderL.valueProperty().removeListener(slideHSL);
    }

    private ChangeListener<Number> slideRGB = new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
                            Number old_val, Number new_val) {

            unsetListenerCMYK();
            unsetListenerHSV();
            unsetListenerHSL();

            rgb.setR((int)sliderR.getValue());
            rgb.setG((int)sliderG.getValue());
            rgb.setB((int)sliderB.getValue());

            colorRectangle.setFill(Color.rgb(rgb.getR(), rgb.getG(), rgb.getB()));
            textR.setText(rgb.getTextR());
            textG.setText(rgb.getTextG());
            textB.setText(rgb.getTextB());

            cmyk = ColorConverter.RGBtoCMYK(rgb);
            textC.setText(cmyk.getTextC());
            sliderC.setValue(cmyk.getC());
            textM.setText(cmyk.getTextM());
            sliderM.setValue(cmyk.getM());
            textY.setText(cmyk.getTextY());
            sliderY.setValue(cmyk.getY());
            textK.setText(cmyk.getTextK());
            sliderK.setValue(cmyk.getK());

            hsv = ColorConverter.RGBtoHSV(rgb);
            textH.setText(hsv.getTextH());
            sliderH.setValue(hsv.getH());
            textS.setText(hsv.getTextS());
            sliderS.setValue(hsv.getS());
            textV.setText(hsv.getTextV());
            sliderV.setValue(hsv.getV());

            hsl = ColorConverter.RGBtoHSL(rgb);
            textH1.setText(hsl.getTextH());
            sliderH1.setValue(hsl.getH());
            textS1.setText(hsl.getTextS());
            sliderS1.setValue(hsl.getS());
            textL.setText(hsl.getTextL());
            sliderL.setValue(hsl.getL());

            setListenerCMYK();
            setListenerHSV();
            setListenerHSL();
        }
    };

    private ChangeListener<Number> slideCMYK = new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
                            Number old_val, Number new_val) {

            unsetListenerRGB();
            unsetListenerHSV();
            unsetListenerHSL();

            cmyk.setC(sliderC.getValue());
            cmyk.setM(sliderM.getValue());
            cmyk.setY(sliderY.getValue());
            cmyk.setK(sliderK.getValue());

            textC.setText(cmyk.getTextC());
            textM.setText(cmyk.getTextM());
            textY.setText(cmyk.getTextY());
            textK.setText(cmyk.getTextK());

            RGB rgb = ColorConverter.CMYKtoRGB(cmyk);

            colorRectangle.setFill(Color.rgb(rgb.getR(), rgb.getG(), rgb.getB()));
            textR.setText(rgb.getTextR());
            textG.setText(rgb.getTextG());
            textB.setText(rgb.getTextB());
            sliderR.setValue(rgb.getR());
            sliderG.setValue(rgb.getG());
            sliderB.setValue(rgb.getB());

            hsv = ColorConverter.RGBtoHSV(rgb);
            textH.setText(hsv.getTextH());
            sliderH.setValue(hsv.getH());
            textS.setText(hsv.getTextS());
            sliderS.setValue(hsv.getS());
            textV.setText(hsv.getTextV());
            sliderV.setValue(hsv.getV());

            hsl = ColorConverter.RGBtoHSL(rgb);
            textH1.setText(hsl.getTextH());
            sliderH1.setValue(hsl.getH());
            textS1.setText(hsl.getTextS());
            sliderS1.setValue(hsl.getS());
            textL.setText(hsl.getTextL());
            sliderL.setValue(hsl.getL());

            setListenerRGB();
            setListenerHSV();
            setListenerHSL();

        }
    };

    private ChangeListener<Number> slideHSV = new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
                            Number old_val, Number new_val) {

            unsetListenerRGB();
            unsetListenerCMYK();
            unsetListenerHSL();

            hsv.setH((int)sliderH.getValue());
            hsv.setS(sliderS.getValue());
            hsv.setV(sliderV.getValue());

            textH.setText(hsv.getTextH());
            textS.setText(hsv.getTextS());
            textV.setText(hsv.getTextV());

            RGB rgb = ColorConverter.HSVtoRGB(hsv);

            colorRectangle.setFill(Color.rgb(rgb.getR(), rgb.getG(), rgb.getB()));
            textR.setText(rgb.getTextR());
            textG.setText(rgb.getTextG());
            textB.setText(rgb.getTextB());
            sliderR.setValue(rgb.getR());
            sliderG.setValue(rgb.getG());
            sliderB.setValue(rgb.getB());

            cmyk = ColorConverter.RGBtoCMYK(rgb);
            textC.setText(cmyk.getTextC());
            sliderC.setValue(cmyk.getC());
            textM.setText(cmyk.getTextM());
            sliderM.setValue(cmyk.getM());
            textY.setText(cmyk.getTextY());
            sliderY.setValue(cmyk.getY());
            textK.setText(cmyk.getTextK());
            sliderK.setValue(cmyk.getK());

            hsl = ColorConverter.RGBtoHSL(rgb);
            textH1.setText(hsl.getTextH());
            sliderH1.setValue(hsl.getH());
            textS1.setText(hsl.getTextS());
            sliderS1.setValue(hsl.getS());
            textL.setText(hsl.getTextL());
            sliderL.setValue(hsl.getL());

            setListenerRGB();
            setListenerCMYK();
            setListenerHSL();

        }
    };

    private ChangeListener<Number> slideHSL = new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
                            Number old_val, Number new_val) {

            unsetListenerRGB();
            unsetListenerCMYK();
            unsetListenerHSV();

            hsl.setH((int)sliderH1.getValue());
            hsl.setS(sliderS1.getValue());
            hsl.setL(sliderL.getValue());

            textH1.setText(hsl.getTextH());
            textS1.setText(hsl.getTextS());
            textL.setText(hsl.getTextL());

            RGB rgb = ColorConverter.HSLtoRGB(hsl);

            colorRectangle.setFill(Color.rgb(rgb.getR(), rgb.getG(), rgb.getB()));
            textR.setText(rgb.getTextR());
            textG.setText(rgb.getTextG());
            textB.setText(rgb.getTextB());
            sliderR.setValue(rgb.getR());
            sliderG.setValue(rgb.getG());
            sliderB.setValue(rgb.getB());

            cmyk = ColorConverter.RGBtoCMYK(rgb);
            textC.setText(cmyk.getTextC());
            sliderC.setValue(cmyk.getC());
            textM.setText(cmyk.getTextM());
            sliderM.setValue(cmyk.getM());
            textY.setText(cmyk.getTextY());
            sliderY.setValue(cmyk.getY());
            textK.setText(cmyk.getTextK());
            sliderK.setValue(cmyk.getK());

            hsv = ColorConverter.RGBtoHSV(rgb);
            textH.setText(hsv.getTextH());
            sliderH.setValue(hsv.getH());
            textS.setText(hsv.getTextS());
            sliderS.setValue(hsv.getS());
            textV.setText(hsv.getTextV());
            sliderV.setValue(hsv.getV());

            setListenerRGB();
            setListenerCMYK();
            setListenerHSV();

        }
    };

    @FXML
    private Rectangle colorRectangle;

    @FXML
    private Button button;

    @FXML
    private TextField textR;
    @FXML
    private TextField textG;
    @FXML
    private TextField textB;
    @FXML
    private TextField textC;
    @FXML
    private TextField textM;
    @FXML
    private TextField textY;
    @FXML
    private TextField textK;
    @FXML
    private TextField textH;
    @FXML
    private TextField textS;
    @FXML
    private TextField textV;
    @FXML
    private TextField textH1;
    @FXML
    private TextField textS1;
    @FXML
    private TextField textL;

    @FXML
    private Slider sliderR;
    @FXML
    private Slider sliderG;
    @FXML
    private Slider sliderB;
    @FXML
    private Slider sliderC;
    @FXML
    private Slider sliderM;
    @FXML
    private Slider sliderY;
    @FXML
    private Slider sliderK;
    @FXML
    private Slider sliderH;
    @FXML
    private Slider sliderS;
    @FXML
    private Slider sliderV;
    @FXML
    private Slider sliderH1;
    @FXML
    private Slider sliderS1;
    @FXML
    private Slider sliderL;

    @FXML
    public void initialize(){
        rgb = new RGB();
        cmyk = new CMYK();
        hsv = new HSV();
        hsl = new HSL();

        setListenerRGB();
        setListenerCMYK();
        setListenerHSV();
        setListenerHSL();

        /*
        vSlider.valueProperty().addListener( new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

                int r = (int)vSlider.getValue();
                RGB rgb = new RGB(r, 0, 0);
                String s = " -fx-color: " + rgb.toWeb();
                vSlider.setStyle(s);
               //textR.setText(String.valueOf(vSlider.getValue()));

            }
        });
        */
    }

    @FXML
    public void onClickMethod(){
        button.setText("Thanks!");
        textR.setText("040");
    }

    /*
    @FXML
    private Slider vSlider;
*/

    public void changeColor(MouseEvent mouseEvent) {
       /* int h = (int)vSlider.getValue();
        HSV hsv = new HSV(h, 1.0, 1.0);
        RGB rgb = ColorConverter.HSVtoRGB(hsv);
        String s = ".slider:hover { -fx-color: " + rgb.toWeb() + ";}";
        vSlider.setStyle(s);
        */
    }
}
