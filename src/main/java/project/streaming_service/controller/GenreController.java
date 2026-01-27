package project.streaming_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.streaming_service.dto.GenreDto;
import project.streaming_service.service.GenreService;

/**
 * Created by: Jasurbek
 * DateTime: 1/27/26 6:17 PM
 **/
@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
@Tag(name = "GenreController")
public class GenreController {
    private final GenreService genreService;

    @PostMapping("/create")
    @Operation(
            summary = "Create genre",
            description = "In this endpoint we could create genre, adding new genre in list of genres"
    )
    public ResponseEntity<?> create(GenreDto genreDto) {
        genreService.create(genreDto);
        return ResponseEntity.ok("Created");
    }

}
