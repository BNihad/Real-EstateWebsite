package com.example.secondmainproject.Dao.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
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





}
