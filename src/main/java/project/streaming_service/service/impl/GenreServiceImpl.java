package project.streaming_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.streaming_service.dto.GenreDto;
import project.streaming_service.entity.Genre;
import project.streaming_service.mapper.GenreMapper;
import project.streaming_service.repository.GenreRepository;
import project.streaming_service.service.GenreService;

/**
 * Created by: Jasurbek
 * DateTime: 1/20/26 5:56 PM
 **/
@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreMapper genreMapper;

    private final GenreRepository genreRepository;

    @Override
    @Transactional
    public void create(GenreDto genreDTO) {

        Genre genre = new Genre();

        genre.setName(genreDTO.getName());

        genreRepository.save(genre);
    }
}
