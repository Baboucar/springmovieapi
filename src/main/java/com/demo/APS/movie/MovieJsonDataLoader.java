package com.demo.APS.movie;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class MovieJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MovieJsonDataLoader.class);
    private final ObjectMapper objectMapper;
    private final MovieRepository movieRepository;

    public MovieJsonDataLoader(ObjectMapper objectMapper, @Qualifier("jdbcMovieRepository") MovieRepository movieRepository) {
        this.objectMapper = objectMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (movieRepository.count() == 0) {
            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/movies.json")) {
                Movies allMovies = objectMapper.readValue(inputStream, Movies.class);
                log.info("Reading {} movies from JSON data and saving to database.", allMovies.getMovies().size());
                movieRepository.saveAll(allMovies.getMovies());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Movies already exist in the database. Skipping JSON data loading.");
        }
    }
}
