package org.proway.student.travel_manangement.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.proway.student.travel_manangement.models.Destiny;

import java.time.LocalDate;

public record TravelDto (
        @NotBlank
        @NotNull
        String name,
        @NotBlank
        @NotNull
        Destiny destiny,
        @NotBlank
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate departure,
        @NotBlank
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate arrival,
        double price
    ) {}
