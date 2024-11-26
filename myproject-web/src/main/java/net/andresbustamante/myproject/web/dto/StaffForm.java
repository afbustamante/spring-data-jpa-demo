package net.andresbustamante.myproject.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Valid
@Getter
@Setter
public class StaffForm {

    @NotNull
    @Size(max = 100)
    @JsonProperty("first_name")
    private String firstName;

    @NotNull
    @Size(max = 100)
    @JsonProperty("last_name")
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    private String username;

    @NotNull
    @Size(max = 20)
    private String password;

    @NotNull
    private AddressForm address;

    @JsonProperty("store_id")
    private Short storeId;
}
