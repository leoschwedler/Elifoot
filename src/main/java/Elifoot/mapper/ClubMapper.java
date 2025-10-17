package Elifoot.mapper;

import Elifoot.domain.Club;
import Elifoot.domain.Stadium;
import Elifoot.request.CreateClubRequest;
import Elifoot.response.ClubDetailResponse;
import Elifoot.response.ClubResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClubMapper {

    public ClubResponse toResponse(Club club){
        return ClubResponse.builder()
                .id(club.getId())
                .name(club.getName())
                .founded(club.getFounded())
                .urlImg(club.getUrlImg())
                .build();
    }

    public ClubDetailResponse toResponseDetail(Club club){
        return ClubDetailResponse.builder()
                .id(club.getId())
                .name(club.getName())
                .founded(club.getFounded())
                .urlImg(club.getUrlImg())
                .stadium(StadiumMapper.toResponse(club.getStadium()))
                .build();
    }

    public Club toDomain(CreateClubRequest request){
        return Club.builder()
                .name(request.getName())
                .founded(request.getFounded())
                .urlImg(request.getUrlImg())
                .stadium(Stadium.builder()
                        .id(request.getStadiumId())
                        .build())
                .build();
    }
}
