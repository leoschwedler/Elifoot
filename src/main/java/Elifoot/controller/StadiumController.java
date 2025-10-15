package Elifoot.controller;

import Elifoot.request.CreateStadiumRequest;
import Elifoot.response.StadiumResponse;
import Elifoot.service.stadium.CreateStadiumService;
import Elifoot.service.stadium.FindStadiumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stadium")
@RequiredArgsConstructor
public class StadiumController {

    private final FindStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;


    @GetMapping
    public ResponseEntity<Page<StadiumResponse>> findAll(Pageable pageable){
        Page<StadiumResponse> response = findStadiumService.findAll(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StadiumResponse> findById(@PathVariable Long id){
        StadiumResponse response = findStadiumService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<StadiumResponse> create(@Valid @RequestBody CreateStadiumRequest request){
        StadiumResponse response = createStadiumService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
