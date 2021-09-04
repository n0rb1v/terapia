package com.example.terapia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTherapyCommand {
    @NotBlank
    private String terapeuta;
    @NotBlank
    private String place;
    @IsValidTime
    private LocalDateTime dateTime;
}
