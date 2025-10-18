package Elifoot.service.club;

import Elifoot.domain.Club;
import Elifoot.exeptions.ResourceNotFoundException;
import Elifoot.mapper.ClubMapper;
import Elifoot.mapper.PlayerMapper;
import Elifoot.repository.ClubRepository;
import Elifoot.response.ClubDetailResponse;
import Elifoot.response.ClubResponse;
import Elifoot.response.PlayerResponse;
import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClubService {

    private final ClubRepository repository;

    public Page<ClubResponse> findAll(Pageable pageable){
        return repository.findAll(pageable).map(ClubMapper::toResponse);
    }

    public ClubDetailResponse findById(Long id){
        return repository.findById(id)
                .map(ClubMapper::toResponseDetail)
                .orElseThrow(
                () -> new ResourceNotFoundException("Club not found")
        );
    }

    public Club findClubById(Long id){
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Club not found")
                );
    }


}
