package project.streaming_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.request.RateContentDto;
import project.streaming_service.dto.request.WatchContentDto;
import project.streaming_service.entity.*;
import project.streaming_service.mapper.ContentMapper;
import project.streaming_service.repository.ContentRepository;
import project.streaming_service.repository.RatingRepository;
import project.streaming_service.repository.UserRepository;
import project.streaming_service.service.ContentService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;
    private final ContentMapper contentMapper;
    private final UserRepository usersRepository;
    private final RatingRepository ratingRepository;

    @Override
    public List<ContentDto> getAllContents(Long id) {

        return List.of();
    }

    @Override
    public ContentDto getContent(Long id) {
        Content content = contentRepository.getById(id);
        return contentMapper.toDto(content);
    }

    @Override
    public void rateContent(Long id, RateContentDto rateContentDto) {
        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isEmpty())
            throw new RuntimeException("Content not found");

        Content content = optionalContent.get();

        Optional<User> optionalUser = usersRepository.findById(rateContentDto.getUserId());

        if (optionalUser.isEmpty())
            throw new RuntimeException("User not found");

        User user = optionalUser.get();

        Rating rating = new Rating();
        rating.setRate(rateContentDto.getRate());
        rating.setComment(rateContentDto.getComment());
        rating.setUser(user);
        rating.setContent(content);

        content.getRatings().add(rating);

        contentRepository.save(content);

    }

    @Override
    public void watchContent(Long id, WatchContentDto watchContentDto) {
        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isEmpty())
            throw new RuntimeException("Content not found");

        Content content = optionalContent.get();

        Optional<User> optionalUser = usersRepository.findById(watchContentDto.getUserId());

        if (optionalUser.isEmpty())
            throw new RuntimeException("User not found");

           User user = optionalUser.get();

           List<WatchHistory> histories = user.getWatchHistories();

           for (WatchHistory history : histories){
               if (history.getContent().equals(content)){
                   history.setProgress(watchContentDto.getProgressMinutes());
                   history.setWatchDate(LocalDate.now());

                   usersRepository.save(user);
               }
           }
           WatchHistory watchHistory = new WatchHistory();
        watchHistory.setWatchDate(LocalDate.now());
        watchHistory.setContent(content);
        watchHistory.setProgress(watchContentDto.getProgressMinutes());
        watchHistory.setUser(user);

        histories.add(watchHistory);

        user.setWatchHistories(histories);

        usersRepository.save(user);
    }

    @Override
    public Double getAvgRating(Long id) {
        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isEmpty())
            throw new RuntimeException("Content not found");

        return ratingRepository.findAverageRatingByKContentId(id);
    }

    @Override
    public List<ContentDto> getRecommendedContents(Long id) {
        Pageable pageable = PageRequest.of(0,10);
        List<Content> content = contentRepository.findRecommendedContentByUserId(id, pageable);

        Stream<ContentDto> contentDtoStream = content.stream().map(contentMapper::toDto);


        return contentDtoStream.toList();
    }
}
