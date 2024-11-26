package net.andresbustamante.myproject.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Valid
@Getter
@Setter
public class AddressForm {

    @NotNull
    @JsonProperty("line_1")
    private String line1;

    @JsonProperty("line_2")
    private String line2;

    @Size(max = 5)
    @JsonProperty("postal_code")
    private String postalCode;

    @NotNull
    private String district;

    @NotNull
    private String phone;

    @NotNull
    @Min(1)
    @JsonProperty("city_id")
    private Short cityId;
}
