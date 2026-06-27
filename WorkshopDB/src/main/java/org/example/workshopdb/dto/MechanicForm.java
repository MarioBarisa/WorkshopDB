package org.example.workshopdb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MechanicForm implements Serializable {
    @NotBlank(message = "Name is mandatory.")
    @Size(max = 100)
    String name;

    @Size(max = 20)
    String phone;
}
