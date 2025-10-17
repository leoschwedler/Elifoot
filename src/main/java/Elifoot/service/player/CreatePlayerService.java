package Elifoot.service.player;

import Elifoot.domain.Club;
import Elifoot.domain.Player;
import Elifoot.mapper.ClubMapper;
import Elifoot.mapper.PlayerMapper;
import Elifoot.repository.PlayerRepository;
import Elifoot.request.CreateClubRequest;
import Elifoot.request.CreatePlayerRequest;
import Elifoot.response.ClubDetailResponse;
import Elifoot.response.PlayerDetailResponse;
import Elifoot.service.club.FindClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePlayerService {

    private final FindClubService service;
    private final PlayerRepository repository;

    public PlayerDetailResponse execute(CreatePlayerRequest request){
        Player player = PlayerMapper.toDomain(request);
        if (player.getClub() != null){
            player.setClub(service.findClubById(player.getClub().getId()));
        }
        player = repository.save(player);
        return PlayerMapper.toDetailResponse(player);
    }
}
