package org.example.workshopdb.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.workshopdb.entity.Client}
 */
@Value
public class ClientRequest implements Serializable {
    @NotNull(message = "You need to provide a name.")
    @NotEmpty(message = "Name can not be empty.")
    String name;
    @NotNull(message = "You need to provide the telephone number.")
    @NotEmpty(message = "You need to provide the telephone number.")
    String telnumber;
    String email;
}