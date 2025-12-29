package project.streaming_service.mapper;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.streaming_service.dto.response.ActorDto;
import project.streaming_service.entity.Actor;
import project.streaming_service.mapper.template.BaseMapper;
@Component
@Getter
public class ActorMapper implements BaseMapper<ActorDto, Actor> {
    @Override
    public ActorDto toDto(Actor actor) {
        return new ActorDto(
                actor.getId(),
                actor.getName()
        ) ;
    }

    @Override
    public Actor toEntity(ActorDto actorDto) {
        return null;
    }
}
