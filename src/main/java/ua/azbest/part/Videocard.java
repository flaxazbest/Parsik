package ua.azbest.part;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "videocard")
public class Videocard {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name="price")
    private Integer price;

    @Column(name = "manufacture")
    private String manufacture;

    @Column(name = "chip")
    private String chip;

    @Column(name = "frequency")
    private String frequency;

    @Column(name = "core")
    private String core;

    @Column(name = "volume")
    private String volume;

    @Column(name = "cooling")
    private String cooling;

    @Column(name = "bit")
    private String bit;

    @Column(name = "memory")
    private String memory;

    @Column(name = "dvi")
    private String dvi;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "api3d")
    private String api3d;

    @Column(name = "iface")
    private String iface;

    @Column(name = "power")
    private String power;

    @Column(name = "dimm")
    private String dimm;

    @Column(name = "garranty")
    private String garranty;

    @Column(name = "link")
    private String link;

    public Videocard() {
        this.fullname = null;
        this.price = 0;
        this.manufacture = null;
        this.chip = null;
        this.frequency = null;
        this.core = null;
        this.volume = null;
        this.cooling = null;
        this.bit = null;
        this.memory = null;
        this.dvi = null;
        this.resolution = null;
        this.api3d = null;
        this.iface = null;
        this.power = null;
        this.dimm = null;
        this.garranty = null;
        this.link = null;
    }

    public Videocard(String fullname, Integer price, String manufacture, String chip, String frequency, String core, String volume, String cooling, String bit, String memory, String dvi, String resolution, String api3d, String iface, String power, String dimm, String garranty, String link) {
        this.fullname = fullname;
        this.price = price;
        this.manufacture = manufacture;
        this.chip = chip;
        this.frequency = frequency;
        this.core = core;
        this.volume = volume;
        this.cooling = cooling;
        this.bit = bit;
        this.memory = memory;
        this.dvi = dvi;
        this.resolution = resolution;
        this.api3d = api3d;
        this.iface = iface;
        this.power = power;
        this.dimm = dimm;
        this.garranty = garranty;
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

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getCooling() {
        return cooling;
    }

    public void setCooling(String cooling) {
        this.cooling = cooling;
    }

    public String getBit() {
        return bit;
    }

    public void setBit(String bit) {
        this.bit = bit;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDvi() {
        return dvi;
    }

    public void setDvi(String dvi) {
        this.dvi = dvi;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getApi3d() {
        return api3d;
    }

    public void setApi3d(String api3d) {
        this.api3d = api3d;
    }

    public String getIface() {
        return iface;
    }

    public void setIface(String iface) {
        this.iface = iface;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDimm() {
        return dimm;
    }

    public void setDimm(String dimm) {
        this.dimm = dimm;
    }

    public String getGarranty() {
        return garranty;
    }

    public void setGarranty(String garranty) {
        this.garranty = garranty;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @PrePersist
    void prePersist() {
    }

    @PreUpdate
    void preUpdate() {
    }

    @PreRemove
    void preRemove() {
    }

    @PostLoad
    void postLoad() {
    }

    @PostRemove
    void postRemove() {
    }

    @PostUpdate
    void postUpdate() {
    }

    @PostPersist
    void postPersist() {
    }

    @Override
    public String toString() {
        return "Videocard{" +
                "fullname='" + fullname + '\'' +
                ", price=" + price +
                '}';
    }

    public static Builder newBuilder() {
        return new Videocard().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setFullName(String fullName) {
            Videocard.this.fullname = fullName;
            return this;
        }

        public Builder setPrice(Integer price) {
            Videocard.this.price = price;
            return this;
        }

        public Builder setManufacture(String manufacture) {
            Videocard.this.manufacture = manufacture;
            return this;
        }

        public Builder setChip(String chip) {
            Videocard.this.chip = chip;
            return this;
        }

        public Builder setFrequency(String frequency) {
            Videocard.this.frequency = frequency;
            return this;
        }

        public Builder setCore(String core) {
            Videocard.this.core = core;
            return this;
        }

        public Builder setVolume(String volume) {
            Videocard.this.volume = volume;
            return this;
        }

        public Builder setCooling(String cooling) {
            Videocard.this.cooling = cooling;
            return this;
        }

        public Builder setBit(String bit) {
            Videocard.this.bit = bit;
            return this;
        }

        public Builder setMemory(String memory) {
            Videocard.this.memory = memory;
            return this;
        }

        public Builder setDvi(String dvi) {
            Videocard.this.dvi = dvi;
            return this;
        }

        public Builder setResolution(String resolution) {
            Videocard.this.resolution = resolution;
            return this;
        }

        public Builder setApi3d(String api3d) {
            Videocard.this.api3d = api3d;
            return this;
        }

        public Builder setIface(String iface) {
            Videocard.this.iface = iface;
            return this;
        }

        public Builder setPower(String power) {
            Videocard.this.power = power;
            return this;
        }

        public Builder setDimm(String dimm) {
            Videocard.this.dimm = dimm;
            return this;
        }

        public Builder setGarranty(String garranty) {
            Videocard.this.garranty = garranty;
            return this;
        }

        public Builder setLink(String link) {
            Videocard.this.link = link;
            return this;
        }

        public Videocard build() {
            return Videocard.this;
        }

    }

}
