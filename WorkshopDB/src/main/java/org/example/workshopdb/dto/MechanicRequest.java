package org.example.workshopdb.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.workshopdb.entity.Mechanic}
 */
@Value
public class MechanicRequest implements Serializable {
    @NotNull(message = "You need to provide the name.")
    @NotBlank
    String name;
    @NotNull(message = "You need to provide the telephone number.")
    @NotEmpty(message = "You need to provide the telephone number.")
    String phone;
}