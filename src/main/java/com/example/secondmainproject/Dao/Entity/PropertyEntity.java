package com.example.secondmainproject.Dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyEntity {

    @Id
    private Integer id;
    private String propertyname;
    private String price;
    private String currency;
    private String image;
    private String locationname;
    private String beds;
    private String baths;




}
