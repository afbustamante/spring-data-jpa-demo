package net.andresbustamante.myproject.api.model;

public record StaffCreationDto(Short storeId, String firstName, String lastName, String username, String password, String email, AddressCreationDto address) {
}
