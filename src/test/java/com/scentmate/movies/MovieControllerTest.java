package com.scentmate.movies;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieControllerTest {

    private final MovieRepository repository = Mockito.mock(MovieRepository.class);

    private final MovieController controller = new MovieController(repository);

    @Test
    public void findAll_should_return_nothing_because_db_is_empty() {
        ResponseEntity<List<Movie>>  response = controller.findAll();

        assertEquals(200, response.getStatusCode().value());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void findAll_should_return_entries_contained_in_repo() {
        Movie movie1 = new Movie(1L, "Wonder Woman 1984", "See data.sql");
        Movie movie2 = new Movie(2L, "Pulp Fiction", "Check out moviedb.org for more information");

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(movie1, movie2));

        ResponseEntity<List<Movie>> response = controller.findAll();

        assertEquals(200, response.getStatusCode().value());
        assertEquals(Arrays.asList(movie1, movie2), response.getBody());
    }
}