package Elifoot.request;

import Elifoot.enums.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlayerRequest {
    @NotBlank
    private String name;

    @NotNull
    private int shirtNumber;

    private String urlImg;

    @NotNull
    private Long clubId;

    @NotNull
    private Position position;
}
