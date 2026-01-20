package project.streaming_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.request.RateContentDto;
import project.streaming_service.dto.request.WatchContentDto;
import project.streaming_service.dto.response.CreateActorInContentDTO;
import project.streaming_service.dto.response.CreateContentDTO;
import project.streaming_service.dto.response.CreateGenreInContentDTO;
import project.streaming_service.service.ContentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
@Tag(name = "Content-Controller")
public class ContentController {
    private final ContentService contentService;

    @Operation(
            summary = "Get content",
            description = "In this endpoint we can get one content by content id"
    )
    @GetMapping("/{id}")
    public ContentDto getContent(@PathVariable Long id) {
        return contentService.getContent(id);
    }

    @Operation(
            summary = "Rate a content",
            description = "In this endpoint we can rate a content by content id"
    )
    @PostMapping("/rate/{id}")
    public void rateContent(@PathVariable Long id, @RequestBody RateContentDto rateContentDto) {
        contentService.rateContent(id, rateContentDto);
    }

    @Operation(
            summary = "Watch content",
            description = "In this endpoint we can start to watch content by content id"
    )
    @PostMapping("/watch/{id}")
    public void watchContent(@PathVariable Long id, @RequestBody WatchContentDto watchContentDto) {
        contentService.watchContent(id, watchContentDto);
    }

    @Operation(
            summary = "Get avg rating",
            description = "In this endpoint we can get average rating of content by content id"
    )
    @GetMapping("/getAvgRating/{id}")
    public Double getAvgRating(@PathVariable Long id) {
        return contentService.getAvgRating(id);
    }

    @Operation(
            summary = "Get recommendation of contents",
            description = "In this endpoint we can got recommendation for user by id" +
                    " this endpoint sort contents by genres for user preferences"
    )
    @GetMapping("/recommendation/{id}")
    public List<ContentDto> getRecommendation(@PathVariable Long id) {
        return contentService.getRecommendedContents(id);
    }

    @Operation(
            summary = "Update content",
            description = "In this endpoint we update a content features by content id " +
                    " and content body"
    )
    @PutMapping("/update/{id}")
    public void update(@RequestBody CreateContentDTO contentDTO, @PathVariable Long id) {
        contentService.update(contentDTO, id);
    }

    @Operation(
            summary = "Add actor to content",
            description = "In this endpoint you can add actor to content with body and id "
    )
    @PostMapping("/addActor/{id}")
    public void addActors(@RequestBody CreateActorInContentDTO actorDTO, @PathVariable Long id) {
        contentService.addActors(actorDTO, id);
    }

    @Operation(
            summary = "Add genres to content",
            description = "In this endpoint you can add genres to content by content id"
    )
    @PostMapping("/addGenres/{id}")
    public void addGenres(@RequestBody CreateGenreInContentDTO genreDTO, @PathVariable Long id) {
        contentService.addGenres(genreDTO, id);
    }

    @Operation(
            summary = "Create a content",
            description = "In this endpoint you can create new content"
    )
    @PostMapping("/createContent")
    public void create(@RequestBody CreateContentDTO contentDTO) {
        contentService.create(contentDTO);
    }

    @Operation(
            summary = "Delete content",
            description = "In this endpoint you can delete content by content id"
    )
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        contentService.delete(id);
    }

}
