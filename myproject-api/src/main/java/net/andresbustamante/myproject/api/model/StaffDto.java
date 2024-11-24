package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDto extends PersonDto {

    private Integer id;

    private String email;

    private String username;

    @JsonIgnore
    private String password;

    @JsonProperty("updated_at")
    private Instant lastUpdate;

    private boolean active;

    private AddressDto address;
}
