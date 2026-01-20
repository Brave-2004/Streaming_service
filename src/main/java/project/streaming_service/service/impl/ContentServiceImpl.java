package project.streaming_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.request.RateContentDto;
import project.streaming_service.dto.request.WatchContentDto;
import project.streaming_service.dto.response.CreateActorInContentDTO;
import project.streaming_service.dto.response.CreateContentDTO;
import project.streaming_service.dto.response.CreateGenreInContentDTO;
import project.streaming_service.entity.*;
import project.streaming_service.mapper.ContentMapper;
import project.streaming_service.repository.*;
import project.streaming_service.service.ContentService;
import project.streaming_service.utils.CommonUtil;

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
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;

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

        for (WatchHistory history : histories) {
            if (history.getContent().equals(content)) {
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
    public void create(CreateContentDTO contentDTO) {
        Set<Genre> genres = getGenres(contentDTO);

        Set<Actor> actors = getActors(contentDTO);

        Content content = new Content(
                contentDTO.getName(),
                contentDTO.getDescription(),
                contentDTO.getPublishedYear(),
                contentDTO.getDuration(),
                contentDTO.getContentType(),
                contentDTO.getAgeLimit(),
                contentDTO.getPremiumStatus(),
                actors,
                genres,
                new ArrayList<>(),
                new ArrayList<>()
        );

        contentRepository.save(content);

    }

    @Override
    public void update(CreateContentDTO contentDTO, Long id) {
        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isEmpty())
            throw new RuntimeException("Content not found with ID : ");

        Content content = optionalContent.get();

        content.setName(contentDTO.getName());
        content.setDescription(contentDTO.getDescription());
        content.setPremiumSatusEnum(contentDTO.getPremiumStatus());
        content.setDuration(contentDTO.getDuration());
        content.setContentTypeEnum(contentDTO.getContentType());
        content.setAgeLimitEnum(contentDTO.getAgeLimit());
        content.setPremiumSatusEnum(contentDTO.getPremiumStatus());
        content.setActors(getActors(contentDTO));
        content.setGenres(getGenres(contentDTO));

        contentRepository.save(content);
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
        Pageable pageable = PageRequest.of(0, 10);
        List<Content> content = contentRepository.findRecommendedContentByUserId(id, pageable);

        Stream<ContentDto> contentDtoStream = content.stream().map(contentMapper::toDto);


        return contentDtoStream.toList();
    }

    @Override
    @Transactional
    public void addActors(CreateActorInContentDTO actorDTO, Long id) {

        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isEmpty())
            throw new RuntimeException("Content not found with ID : ");

        Content content = optionalContent.get();

        Set<Actor> actors = CommonUtil.getOrDefault(content.getActors(), new HashSet<>());

        for (Long actorId : actorDTO.getActorIds()) {

            Optional<Actor> optionalActor = actorRepository.findById(actorId);

            if (optionalActor.isEmpty())
                throw new RuntimeException("Actor not found with ID : ");

            actors.add(optionalActor.get());
        }

        content.setActors(actors);

        contentRepository.save(content);
    }

    @Override
    @Transactional
    public void addGenres(CreateGenreInContentDTO genreDTO, Long id) {
        Optional<Content> optionalContent = contentRepository.findById(id);

        if (optionalContent.isEmpty())
            throw new RuntimeException("Content not found with ID : ");

        Content content = optionalContent.get();

        Set<Genre> genres = CommonUtil.getOrDefault(content.getGenres(), new HashSet<>());

        for (Long genreId : genreDTO.getGenreIds()) {

            Optional<Genre> optionalGenre = genreRepository.findById(genreId);

            if (optionalGenre.isEmpty())
                throw new RuntimeException("Genre not found with ID : ");

            genres.add(optionalGenre.get());
        }

        content.setGenres(genres);

    }

    @Override
    public void delete(Long id) {
        contentRepository.deleteById(id);
    }

    private Set<Actor> getActors(CreateContentDTO contentDTO) {
        Set<Actor> actors = new HashSet<>();

        for (Long id : contentDTO.getActorsId()) {

            Optional<Actor> actorOptional = actorRepository.findById(id);

            if (actorOptional.isEmpty()) {

                throw new RuntimeException("Actor not found with ID : ");

            }

            actors.add(actorOptional.get());

        }
        return actors;
    }

    private Set<Genre> getGenres(CreateContentDTO contentDTO) {
        Set<Genre> genres = new HashSet<>();

        for (Long id : contentDTO.getGenresId()) {

            Optional<Genre> genreOptional = genreRepository.findById(id);

            if (genreOptional.isEmpty()) {

                throw new RuntimeException("Genre not found with ID : ");

            }

            genres.add(genreOptional.get());
        }
        return genres;
    }
}
