package Elifoot.service.club;

import Elifoot.domain.Club;
import Elifoot.mapper.ClubMapper;
import Elifoot.repository.ClubRepository;
import Elifoot.request.CreateClubRequest;
import Elifoot.response.ClubDetailResponse;
import Elifoot.service.stadium.FindStadiumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateClubService {

    private final ClubRepository repository;
    private final FindStadiumService service;

    public ClubDetailResponse execute(CreateClubRequest request){
        Club club = ClubMapper.toDomain(request);
        if (club.getStadium() != null){
            club.setStadium(service.findStadiumById(club.getStadium().getId()));
        }
        club = repository.save(club);
        return ClubMapper.toResponseDetail(club);
    }
}
