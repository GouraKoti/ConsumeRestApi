
package com.molcon.ConsumeRestApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "henkel")
public class MongoHenkel {
    @Id //for primary key
    private String mcid;
    private String commonName;
    private String description;
    private String sapCs;

}

