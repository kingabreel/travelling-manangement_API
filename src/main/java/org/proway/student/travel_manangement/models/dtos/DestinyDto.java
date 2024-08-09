package org.proway.student.travel_manangement.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DestinyDto(@NotBlank @NotNull String name,
                         @NotBlank @NotNull String country,
                         @NotBlank @NotNull String city,
                         @NotBlank @NotNull String time_zone
){}