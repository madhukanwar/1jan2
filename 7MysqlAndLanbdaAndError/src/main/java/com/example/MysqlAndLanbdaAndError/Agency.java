package com.example.MysqlAndLanbdaAndError;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Agency {

    @Id
    @GeneratedValue
    public long id;
    @NotEmpty(message = "name cant not empty")
    public String name;
    @NotEmpty(message = "city cant not empty")
    public String city;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
