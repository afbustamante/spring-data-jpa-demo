package net.andresbustamante.myproject.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class Role implements Serializable {

    private Short id;
    private String name;
}
