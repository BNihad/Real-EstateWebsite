package com.example.secondmainproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {

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
