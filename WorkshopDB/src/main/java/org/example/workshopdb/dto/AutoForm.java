package org.example.workshopdb.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.workshopdb.entity.Auto}
 */
@Getter
@Setter
public class AutoForm implements Serializable {
    @NotNull(message = "Client ID must be provided.")
    Integer clientId;

    @Size(message = "Size is invalid.", min = 0, max = 50)
    String make;

    @Size(message = "Size is invalid.", min = 0, max = 50)
    String model;

    @Size(message = "VIN number is excatly 17 characters long.", min = 0, max = 17)
    String vin;

    String enginetype;
    @Size(message = "Size is invalid.", max = 50)

    String engine;

    Integer kW;

    @Min(1900)
    Integer year;

    Integer mileage;
}