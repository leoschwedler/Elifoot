package Elifoot.service.stadium;

import Elifoot.domain.Stadium;
import Elifoot.mapper.StadiumMapper;
import Elifoot.repository.StadiumRepository;
import Elifoot.request.CreateStadiumRequest;
import Elifoot.response.StadiumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStadiumService {

    private final StadiumRepository repository;

    public StadiumResponse execute(CreateStadiumRequest request){
        Stadium stadium = StadiumMapper.toDomain(request);
        stadium = repository.save(stadium);
        return StadiumMapper.toResponse(stadium);
    }
}
