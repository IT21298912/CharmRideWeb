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
@Document(collection = "inspector")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Inspector {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
