package Elifoot.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDetailResponse {
    private long id;
    private String name;
    private String position;
    private int shirtNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String urlImg;
    private ClubResponse club;
}
