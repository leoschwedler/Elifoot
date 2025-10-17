package Elifoot.service.player;

import Elifoot.exeptions.ResourceNotFoundException;
import Elifoot.mapper.PlayerMapper;
import Elifoot.repository.PlayerRepository;
import Elifoot.response.PlayerDetailResponse;
import Elifoot.response.PlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class FindPlayerService {

    private final PlayerRepository repository;


    public Page<PlayerResponse> findAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(PlayerMapper::toResponse);
    }

    public PlayerDetailResponse findById(Long id){
        return repository.findById(id)
                .map(PlayerMapper::toDetailResponse)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Player not found")
                );
    }
}
