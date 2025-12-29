package project.streaming_service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.response.RatingDto;
import project.streaming_service.dto.response.UserDto;
import project.streaming_service.dto.response.WatchHistoryDto;
import project.streaming_service.entity.Rating;
import project.streaming_service.entity.User;
import project.streaming_service.entity.WatchHistory;
import project.streaming_service.mapper.template.BaseMapper;
import project.streaming_service.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<UserDto, User> {

    private final RatingMapper ratingMapper;

    private final WatchHistoryMapper watchHistoryMapper;

    @Override
    public UserDto toDto(User user) {
        List<RatingDto> ratingDTOS = CommonUtil.getOrDefault(user.getRatings(), new ArrayList<Rating>())
                .stream()
                .map(ratingMapper::toDto).toList();

        List<WatchHistoryDto> historyDTOS = CommonUtil.getOrDefault(user.getWatchHistories(), new ArrayList<WatchHistory>())
                .stream()
                .map(watchHistoryMapper::toDto).toList();

        return new UserDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getSubscription().getId(),
                ratingDTOS,
                historyDTOS
        );
    }

    @Override
    public User toEntity(UserDto userDto) {
        return null;
    }
}
