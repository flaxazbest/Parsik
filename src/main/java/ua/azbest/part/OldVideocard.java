package ua.azbest.part;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OldVideocard implements Serializable {

    private String fullName;
    private String manufacture;
    private int price;
    private HashMap<String, String> detail;

    public HashMap<String, String> getDetail() {
        return detail;
    }

    public void setDetail(HashMap<String, String> detail) {
        this.detail = detail;
    }

    public OldVideocard(String fullName, String manufacture, int price, HashMap<String, String> detail) {
        this.fullName = fullName;
        this.manufacture = manufacture;
        this.price = price;
        this.detail = detail;
    }

    public OldVideocard(String fullName, String manufacture, int price) {
        this.fullName = fullName;
        this.manufacture = manufacture;
        this.price = price;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry: detail.entrySet()) {
            sb.append(entry.getKey());
            sb.append('\t');
            sb.append(entry.getValue());
            sb.append('\n');
        }

        return "OldVideocard{" +
                "fullName='" + fullName + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", price=" + price +
                '}' + sb.toString();
    }
}
