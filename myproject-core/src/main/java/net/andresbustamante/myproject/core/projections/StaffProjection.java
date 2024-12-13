package net.andresbustamante.myproject.core.projections;

public interface StaffProjection {

    Short getId();
    String getFirstName();
    String getLastName();
    String getUsername();
    String getEmail();
    boolean isActive();
    String getAddressLine1();
    String getAddressLine2();
    String getPostalCode();
    String getCity();
    String getCountry();
    String getPhone();
}
