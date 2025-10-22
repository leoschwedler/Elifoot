package Elifoot.controller;

import Elifoot.config.security.annotations.CanReadPlayer;
import Elifoot.config.security.annotations.CanWritePlayer;
import Elifoot.request.CreatePlayerRequest;
import Elifoot.response.PlayerDetailResponse;
import Elifoot.response.PlayerResponse;
import Elifoot.service.player.CreatePlayerService;
import Elifoot.service.player.FindPlayerService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("player")
public class PlayerController {

    private final FindPlayerService findPlayerService;
    private final CreatePlayerService createPlayerService;

    @CanWritePlayer
    @PostMapping
    public ResponseEntity<PlayerDetailResponse> create(@RequestBody CreatePlayerRequest request){
        PlayerDetailResponse response = createPlayerService.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @CanReadPlayer
    @GetMapping
    public ResponseEntity<Page<PlayerResponse>> findAll(Pageable pageable){
        Page<PlayerResponse> response = findPlayerService.findAll(pageable);
        return ResponseEntity.ok(response);
    }

    @CanReadPlayer
    @GetMapping("/{id}")
    public ResponseEntity<PlayerDetailResponse> findAById(@PathVariable long id){
        PlayerDetailResponse response = findPlayerService.findById(id);
        return ResponseEntity.ok(response);
    }
}
