package net.andresbustamante.myproject.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String firstName;
    private String surname;
    private String gender;
    private String email;
}
