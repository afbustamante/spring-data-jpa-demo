package net.andresbustamante.myproject.api.model;

public record AddressCreationDto(String line1, String line2, String postalCode, String district, String phone, Short cityId) {
}
