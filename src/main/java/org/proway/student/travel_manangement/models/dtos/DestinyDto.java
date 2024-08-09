package org.proway.student.travel_manangement.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DestinyDto(
        @NotBlank (message = "destiny's name cannot be null")
        @NotNull
        String name,
        @NotBlank (message = "destiny country cannot be null")
        @NotNull
        String country,
        @NotBlank (message = "destiny city cannot be null")
        @NotNull
        String city,
        @NotBlank (message = "destiny time zone cannot be null")
        @NotNull
        @Pattern(regexp = "^[A-Z]{3}[-+]\\\\d{2}$", message = "Time zone must be 'XXX-00'")
        String time_zone
){}