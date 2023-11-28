package com.example.charmRides.modal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "booking")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Booking {
    @Id
    private String bid;
    private String uid;
    private String vid;
    private Date date;
}
