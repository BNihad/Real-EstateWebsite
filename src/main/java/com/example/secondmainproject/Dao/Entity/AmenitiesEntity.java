package com.example.secondmainproject.Dao.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "amenities")
public class AmenitiesEntity {

    @Id
    private Integer id;
    private String balcony;
    private String outdoor_kitchen;
    private String cable_tv;
    private String deck;
    private String tennis_court;
    private String internet;
    private String parking;
    private String sun_room;

    private String concrete_flooring;
    private String location_map;



}
