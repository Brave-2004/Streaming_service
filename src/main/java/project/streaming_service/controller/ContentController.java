package project.streaming_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.request.RateContentDto;
import project.streaming_service.dto.request.WatchContentDto;
import project.streaming_service.service.ContentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class ContentController {
    private final ContentService contentService;

    @GetMapping("/all/{id}")
    public List<ContentDto> getAllContents(@PathVariable Long id) {
        return contentService.getAllContents(id);
    }

    @GetMapping("/content/{id}")
    public ContentDto getContent(@PathVariable Long id) {
        return contentService.getContent(id);
    }

    @PostMapping("/rate/{id}")
    public void rateContent(@PathVariable Long id, @RequestBody RateContentDto rateContentDto) {
        contentService.rateContent(id, rateContentDto);
    }

    @PostMapping("/watch/{id}")
    public void watchContent(@PathVariable Long id, @RequestBody WatchContentDto watchContentDto) {
        contentService.watchContent(id, watchContentDto);
    }

    @GetMapping("/{id}")
    public Double getAvgRating(@PathVariable Long id) {
        return contentService.getAvgRating(id);
    }

    @GetMapping("/recommendation/{id}")
    public List<ContentDto> getRecommendation(@PathVariable Long id) {
        return contentService.getRecommendedContents(id);
    }

}
