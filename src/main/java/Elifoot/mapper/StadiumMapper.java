package Elifoot.mapper;

import Elifoot.domain.Stadium;
import Elifoot.request.CreateStadiumRequest;
import Elifoot.response.StadiumResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StadiumMapper {

    public StadiumResponse toResponse(Stadium stadium){
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .imgUrl(stadium.getUrlImg())
                .build();
    }

    public Stadium toDomain(CreateStadiumRequest request){
        return Stadium.builder()
                .name(request.getName())
                .city(request.getCity())
                .capacity(request.getCapacity())
                .urlImg(request.getUrlImg())
                .build();
    }
}
