package project.streaming_service.service;

import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.request.RateContentDto;
import project.streaming_service.dto.request.WatchContentDto;
import project.streaming_service.dto.response.CreateActorInContentDTO;
import project.streaming_service.dto.response.CreateContentDTO;
import project.streaming_service.dto.response.CreateGenreInContentDTO;

import java.util.List;

public interface ContentService {
    ContentDto getContent(Long id);

    void rateContent(Long id, RateContentDto rateContentDto);

    void watchContent(Long id, WatchContentDto watchContentDto);

    void create(CreateContentDTO contentDTO);

    void update(CreateContentDTO contentDTO, Long id);

    Double getAvgRating(Long id );

    List<ContentDto> getRecommendedContents(Long id);

    void addActors(CreateActorInContentDTO actorDTO, Long id);

    void addGenres(CreateGenreInContentDTO genreDTO, Long id);

    void delete(Long id);
}
