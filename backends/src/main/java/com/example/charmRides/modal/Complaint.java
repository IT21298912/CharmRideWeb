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
@Document(collection = "complaint")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Complaint {
    @Id
    private String cid;
    private String busName;
    private String userName;
    private String inspector;
    private String status;
    private String description;
}
