package Elifoot.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StadiumResponse {
    private Long id;
    private String name;
    private String city;
    private Integer capacity;
    private String imgUrl;
}
