package com.example.charmRides.modal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bus")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Bus {

    @Id
    private String id;
    private String name;
    private String vehicleNum;
    private String busType;
    private int seats;
    private String price;
    private String driver;
    private String fromLocation;
    private String toLocation;
    private String shedule;


}
