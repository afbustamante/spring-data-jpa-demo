package net.andresbustamante.myproject.api.model;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelayedRentalDto {

    private Integer rentalId;
    private Instant rentalDate;
    private String filmTitle;
    private Integer totalRentalDuration;
    private Integer filmRentalDuration;
    private Integer delay;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private boolean isCustomerActive;
}
