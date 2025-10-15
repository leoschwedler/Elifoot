package Elifoot.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StadiumResponse {
    private Long id;
    private String name;
    private String city;
    private Integer capacity;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imgUrl;
}
