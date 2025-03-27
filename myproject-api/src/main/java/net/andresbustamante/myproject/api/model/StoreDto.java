package net.andresbustamante.myproject.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDto {

    private Short id;
    private String name;
    private StaffDto manager;
    private AddressDto address;
}
