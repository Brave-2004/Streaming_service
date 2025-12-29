package project.streaming_service.service;

import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.request.RateContentDto;
import project.streaming_service.dto.request.WatchContentDto;

import java.util.List;

public interface ContentService {

    List<ContentDto> getAllContents(Long id);

    ContentDto getContent(Long id);

    void rateContent(Long id, RateContentDto rateContentDto);

    void watchContent(Long id, WatchContentDto watchContentDto);

    Double getAvgRating(Long id );

    List<ContentDto> getRecommendedContents(Long id);
}
