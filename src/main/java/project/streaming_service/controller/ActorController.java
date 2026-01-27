package project.streaming_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.streaming_service.dto.response.ActorDto;
import project.streaming_service.service.ActorService;

/**
 * Created by: Jasurbek
 * DateTime: 1/27/26 6:08 PM
 **/
@RestController
@RequestMapping("/api/actor")
@RequiredArgsConstructor
@Tag(name = "ActorController")
public class ActorController {
    private final ActorService actorService;

    @PostMapping("/create")
    @Operation(
            summary = "Create actor",
            description = "In this endpoint we could create actor, adding new actor to our actor list"
    )
    public ResponseEntity<?> create(ActorDto actorDTO) {
        actorService.create(actorDTO);
        return ResponseEntity.ok("Created");
    }
}
