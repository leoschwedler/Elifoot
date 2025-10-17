package Elifoot.mapper;

import Elifoot.domain.Club;
import Elifoot.domain.Player;
import Elifoot.enums.Position;
import Elifoot.request.CreatePlayerRequest;
import Elifoot.response.PlayerDetailResponse;
import Elifoot.response.PlayerResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlayerMapper {

    public PlayerResponse toResponse(Player player){
        return PlayerResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .position(enumToString(player.getPosition()))
                .shirtNumber(player.getShirtNumber())
                .urlImg(player.getUrlImg())
                .build();
    }

    public PlayerDetailResponse toDetailResponse(Player player){
        return PlayerDetailResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .position(enumToString(player.getPosition()))
                .shirtNumber(player.getShirtNumber())
                .urlImg(player.getUrlImg())
                .club(ClubMapper.toResponse(player.getClub()))
                .build();

    }

    public Player toDomain(CreatePlayerRequest request){
        return Player.builder()
                .name(request.getName())
                .position(request.getPosition())
                .shirtNumber(request.getShirtNumber())
                .urlImg(request.getUrlImg())
                .club(Club.builder()
                        .id(request.getClubId())
                        .build())
                .build();
    }

    private String enumToString(Position position) {
        return position != null ? position.name() : null; // ou position.getLabel() se tiver
    }

    private Position stringToEnum(String position) {
        return position != null ? Position.valueOf(position.toUpperCase()) : null;
    }
}
