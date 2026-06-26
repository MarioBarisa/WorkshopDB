package org.example.workshopdb.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.workshopdb.entity.Client}
 */
@Getter
@Setter
public class ClientForm implements Serializable {
    @Size(message = "Name size is invalid.", min = 0, max = 100)
    @NotBlank(message = "Name is mandatory.")
    String name;

    @Size(message = "Telephone number size is invalid.", min = 0, max = 20)
    String telnumber;

    @Size(message = "Invalid name length", min = 0, max = 100)
    @Email(message = "Enter valid email adress.")
    String email;

}