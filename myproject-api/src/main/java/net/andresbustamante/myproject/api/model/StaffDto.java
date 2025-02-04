package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffDto extends PersonDto {

    private Integer id;
    private String email;
    private String username;
    private String password;
    private Instant lastUpdate;
    private boolean active;
    private AddressDto address;
}
