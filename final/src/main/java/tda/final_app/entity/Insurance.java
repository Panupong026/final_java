package tda.final_app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
	private String name;
	private String coverage_class;
    private int price;
    private int car_coverage;
	private int medicine_coverage;
	private int third_party_coverage;
	private boolean lost;
	private String urls;

    // Constructor

    public Insurance(String name, String coverage_class, int price) {
        this.name = name;
        this.coverage_class = coverage_class;
        this.price = price;
    }

    public Insurance() {

    }

    // Getter, Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverage_class() {
        return coverage_class;
    }

    public void setCoverage_class(String coverage_class) {
        this.coverage_class = coverage_class;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCar_coverage() {
        return car_coverage;
    }

    public void setCar_coverage(int car_coverage) {
        this.car_coverage = car_coverage;
    }

    public int getMedicine_coverage() {
        return medicine_coverage;
    }

    public void setMedicine_coverage(int medicine_coverage) {
        this.medicine_coverage = medicine_coverage;
    }

    public int getThird_party_coverage() {
        return third_party_coverage;
    }

    public void setThird_party_coverage(int third_party_coverage) {
        this.third_party_coverage = third_party_coverage;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

}
