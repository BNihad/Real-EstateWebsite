package com.example.secondmainproject.Dao.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "properties")
public class PropertyEntity {

    @Id
    private Integer id;
    private String property_name;
    private String price;
    private String currency;
    private String property_image;
    private String property_image2;
    private String property_image3;
    private String property_location;
    private String beds;
    private String baths;
    private String description;
    private String property_id;
    private String property_type;
    private String area;
    private String garage;

    public PropertyEntity() {
    }

    public PropertyEntity(Integer id, String property_name, String price, String currency, String property_image, String property_image2, String property_image3, String property_location, String beds, String baths, String description, String property_id, String property_type, String area, String garage) {
        this.id = id;
        this.property_name = property_name;
        this.price = price;
        this.currency = currency;
        this.property_image = property_image;
        this.property_image2 = property_image2;
        this.property_image3 = property_image3;
        this.property_location = property_location;
        this.beds = beds;
        this.baths = baths;
        this.description = description;
        this.property_id = property_id;
        this.property_type = property_type;
        this.area = area;
        this.garage = garage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProperty_name() {
        return property_name;
    }

    public void setProperty_name(String property_name) {
        this.property_name = property_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProperty_image() {
        return property_image;
    }

    public void setProperty_image(String property_image) {
        this.property_image = property_image;
    }

    public String getProperty_image2() {
        return property_image2;
    }

    public void setProperty_image2(String property_image2) {
        this.property_image2 = property_image2;
    }

    public String getProperty_image3() {
        return property_image3;
    }

    public void setProperty_image3(String property_image3) {
        this.property_image3 = property_image3;
    }

    public String getProperty_location() {
        return property_location;
    }

    public void setProperty_location(String property_location) {
        this.property_location = property_location;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getBaths() {
        return baths;
    }

    public void setBaths(String baths) {
        this.baths = baths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getGarage() {
        return garage;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }
}
