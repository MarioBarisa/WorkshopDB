package org.example.workshopdb.dto;

import jakarta.validation.constraints.*;
import lombok.Value;
import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.entity.Client;

import java.io.Serializable;

/**
 * DTO for {@link Auto}
 */
@Value
public class AutoRequest implements Serializable {
    @NotNull(message = "You need to provide car make.")
    @NotEmpty(message = "You need to provide car make.")
    String make;
    @NotNull(message = "You need to provide car model.")
    @NotEmpty(message = "You need to provide car model.")
    String model;
    String vin;
    @NotNull(message = "You need to provide engine type.")
    @NotEmpty(message = "You need to provide engine type.")
    String enginetype;
    @NotNull(message = "You need to provide the engine.")
    @NotEmpty(message = "You need to provide the engine.")
    String engine;
    @NotNull(message = "You need to provide the kW of the engine.")
    @Min(message = "0", value = 0L)
    @Max(message = "kw cant be higher than 1000", value = 1000)
    Integer powerKW;
    @NotNull
    @Min(message = "There are no cars older than 1900.", value = 1900)
    @Positive(message = "Year can only be positive.")
    Integer year;
    @NotNull(message = "You need to provide mielage.")
    @Min(0L)
    @PositiveOrZero(message = "Mileage cant be negative")
    Integer mileage;

    @NotNull(message = "You need to provide Client ID.")
    @Min(0L)
    @PositiveOrZero(message = "Client ID cant be negative")
    Integer clientID;
}