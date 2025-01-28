package net.andresbustamante.myproject.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    @JsonProperty("line_1")
    private String line1;

    @JsonProperty("line_2")
    private String line2;

    @JsonProperty("postal_code")
    private String postalCode;

    private String city;

    private String country;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
