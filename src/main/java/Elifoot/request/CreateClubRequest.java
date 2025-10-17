package Elifoot.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class CreateClubRequest {
    @NotBlank
    private String name;

    @NotNull
    private LocalDate founded;

    private String urlImg;

    private Long stadiumId;
}
