package com.example.secondmainproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {

    private Integer id;
    private String propertyname;
    private String locationname;
    private String beds;
    private String baths;
    private String price;
    private String currency;
    private String image;

}
