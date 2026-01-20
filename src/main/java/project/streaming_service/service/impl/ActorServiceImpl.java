package project.streaming_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.streaming_service.dto.response.ActorDto;
import project.streaming_service.entity.Actor;
import project.streaming_service.repository.ActorRepository;
import project.streaming_service.service.ActorService;

/**
 * Created by:
 * DateTime: 1/20/26 5:54 PM
 **/
@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Override
    @Transactional
    public void create(ActorDto actorDTO) {

        Actor actor = new Actor();

        actor.setName(actorDTO.getName());

        actorRepository.save(actor);

    }
}
