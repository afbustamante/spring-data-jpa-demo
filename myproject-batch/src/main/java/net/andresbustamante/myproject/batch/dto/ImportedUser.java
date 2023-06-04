package net.andresbustamante.myproject.batch.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ImportedUser implements Serializable {

    private String firstName;
    private String surname;
    private String email;
    private String gender;
}
