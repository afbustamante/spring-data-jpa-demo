package net.andresbustamante.myproject.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private String line1;
    private String line2;
    private String postalCode;
    private String city;
    private String country;
    private String phoneNumber;
}
