package Elifoot.controller;

import Elifoot.request.CreateClubRequest;
import Elifoot.response.ClubDetailResponse;
import Elifoot.response.ClubResponse;
import Elifoot.response.PlayerResponse;
import Elifoot.service.club.CreateClubService;
import Elifoot.service.club.FindClubService;
import Elifoot.service.player.FindPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("club")
@RequiredArgsConstructor
public class ClubController {

    private final FindClubService findClubService;
    private final CreateClubService createClubService;
    private final FindPlayerService findPlayerService;


    @GetMapping
    public ResponseEntity<Page<ClubResponse>> findAll(Pageable pageable){
        Page<ClubResponse> response = findClubService.findAll(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubDetailResponse> findById(@PathVariable Long id){
        ClubDetailResponse response = findClubService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ClubDetailResponse> create(@RequestBody CreateClubRequest request){
        ClubDetailResponse response = createClubService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<PlayerResponse>> findPlayersByClubId(@PathVariable Long id){
        List<PlayerResponse> response = findPlayerService.findPlayersByClubId(id);
        return ResponseEntity.ok(response);
    }
}
