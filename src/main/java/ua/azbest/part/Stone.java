package ua.azbest.part;

import javax.persistence.*;

@Entity
@Table(name = "core")
public class Stone {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name="price")
    private Integer price;

    @Column(name = "family")
    private String family;

    @Column(name = "socket")
    private String socket;

    @Column(name = "cores")
    private String cores;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "graphic")
    private String graphic;

    @Column(name = "box")
    private String box;

    @Column(name = "pin")
    private String pin;

    @Column(name = "generation")
    private String generation;

    @Column(name = "link")
    private String link;

    public Stone() {
        this.fullname = null;
        this.price = 0;
        this.family = null;
        this.socket = null;
        this.cores = null;
        this.frequency = null;
        this.graphic = null;
        this.box = null;
        this.pin = null;
        this.generation = null;
        this.link = null;
    }

    public Stone(String fullname, Integer price, String manufacture, String family, String socket, String cores, String frequency, String graphic, String box, String pin, String generation, String link) {
        this.fullname = fullname;
        this.price = price;
        this.family = family;
        this.socket = socket;
        this.cores = cores;
        this.frequency = frequency;
        this.graphic = graphic;
        this.box = box;
        this.pin = pin;
        this.generation = generation;
        this.link = link;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getCores() {
        return cores;
    }

    public void setCore(String cores) {
        this.cores = cores;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static Stone.Builder newBuilder() {
        return new Stone().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setFullName(String fullName) {
            Stone.this.fullname = fullName;
            return this;
        }

        public Builder setPrice(Integer price) {
            Stone.this.price = price;
            return this;
        }

        public Builder setFamily(String family) {
            Stone.this.family = family;
            return this;
        }

        public Builder setSocket(String socket) {
            Stone.this.socket = socket;
            return this;
        }

        public Builder setCore(String cores) {
            Stone.this.cores = cores;
            return this;
        }

        public Builder setFrequency(String frequency) {
            Stone.this.frequency = frequency;
            return this;
        }

        public Builder setGraphic(String graphic) {
            Stone.this.graphic = graphic;
            return this;
        }

        public Builder setBox(String box) {
            Stone.this.box = box;
            return this;
        }

        public Builder setPin(String pin) {
            Stone.this.pin = pin;
            return this;
        }

        public Builder setGeneration(String generation) {
            Stone.this.generation = generation;
            return this;
        }

        public Builder setLink(String link) {
            Stone.this.link = link;
            return this;
        }

        public Stone build() {
            return Stone.this;
        }

    }


}
