package Elifoot.controller;

import Elifoot.enums.Position;
import Elifoot.response.PositionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("resource/")
public class ResourceController {

    @GetMapping("positions")
    public ResponseEntity<List<PositionResponse>> getPositions(){
        List<PositionResponse> response = Arrays.stream(Position.values())
                .map(position -> new PositionResponse(position.name(), position.getLabel()))
                .toList();
        return ResponseEntity.ok(response);
    }
}
