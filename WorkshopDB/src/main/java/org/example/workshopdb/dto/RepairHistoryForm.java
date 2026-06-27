package org.example.workshopdb.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class RepairHistoryForm implements Serializable {
    @NotNull(message = "You must provide Auto.")
    Integer autoId;

    @NotNull(message = "You must provide Mechanic.")
    Integer mechanicId;

    @NotNull(message = "You must provide date.")
    LocalDate date;

    @NotNull(message = "You must provide a title.")
    @NotEmpty(message = "You must provide a title.")
    String title;

    String about;

    @NotNull
    @Min(message = "Price needs to be positive.", value = 0)
    BigDecimal price;
}
