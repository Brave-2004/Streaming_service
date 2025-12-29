package project.streaming_service.mapper;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.entity.WatchHistory;
import project.streaming_service.mapper.template.BaseMapper;
@Component
@Getter
public class WatchHistoryMapper implements BaseMapper<WatchHistoryDto, WatchHistory> {
    @Override
    public WatchHistoryDto toDto(WatchHistory watchHistory) {

        return new WatchHistoryDto(
                watchHistory.getWatchDate(),
                watchHistory.getProgress(),
                watchHistory.getUser().getId(),
                watchHistory.getContent().getId()
        );
    }

    @Override
    public WatchHistory toEntity(WatchHistoryDto watchHistoryDto) {
        return null;
    }
}
