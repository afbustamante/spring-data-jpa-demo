package net.andresbustamante.myproject.core.projections;

public interface StaffProjection {

    Short getId();
    String getFirstName();
    String getLastName();
    String getUsername();
    String getEmail();
    boolean isActive();
    String getAddress1();
    String getAddress2();
    String getPostalCode();
    String getCity();
    String getCountry();
    String getPhone();
}
