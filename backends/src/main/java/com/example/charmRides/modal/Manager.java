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
@Document(collection = "manager")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Manager {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private int mobile;
}
