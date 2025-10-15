package Elifoot.service.stadium;

import Elifoot.exeptions.ResourceNotFoundException;
import Elifoot.mapper.StadiumMapper;
import Elifoot.repository.StadiumRepository;
import Elifoot.response.StadiumResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindStadiumService {

    private final StadiumRepository repository;

    public Page<StadiumResponse> findAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(StadiumMapper::toResponse);
    }

    public StadiumResponse findById(Long id){
        return repository.findById(id)
                .map(StadiumMapper::toResponse)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Stadium not found with id:" + id));
    }
}
