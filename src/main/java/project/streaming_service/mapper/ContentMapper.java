package project.streaming_service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.request.ContentDto;
import project.streaming_service.dto.response.ActorDto;
import project.streaming_service.dto.response.GenreDto;
import project.streaming_service.dto.response.RatingDto;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.entity.*;
import project.streaming_service.mapper.template.BaseMapper;
import project.streaming_service.utils.CommonUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContentMapper implements BaseMapper<ContentDto, Content> {
    private final ActorMapper actorMapper;
    private final GenreMapper genreMapper;
    private final RatingMapper ratingMapper;
    private final WatchHistoryMapper watchHistoryMapper;


    @Override
    public ContentDto toDto(Content content) {

        Set<ActorDto> actorDTOs = CommonUtil.getOrDefault(content.getActors(),new HashSet<Actor>())
                .stream().map(actorMapper::toDto).collect(Collectors.toSet());

        Set<GenreDto> genreDTOs = CommonUtil.getOrDefault(content.getGenres(),new HashSet<Genre>())
                .stream().map(genreMapper::toDto).collect(Collectors.toSet());

        List<RatingDto> ratingDTOs = CommonUtil.getOrDefault(content.getRatings(),new HashSet<Rating>())
                .stream().map(ratingMapper::toDto).toList();

        List<WatchHistoryDto> watchHistoryDTOs = CommonUtil.getOrDefault(content.getWatchHistories(),new HashSet<WatchHistory>())
                .stream().map(watchHistoryMapper::toDto).toList();


        return new ContentDto(
                content.getId(),
                content.getName(),
                content.getDescription(),
                content.getIssueDate(),
                content.getDuration(),
                content.getContentTypeEnum(),
                content.getAgeLimitEnum(),
                content.getPremiumSatusEnum(),
                actorDTOs,
                genreDTOs,
                ratingDTOs,
                watchHistoryDTOs
        );

    }

    @Override
    public Content toEntity(ContentDto contentDto) {
        return null;
    }
}
