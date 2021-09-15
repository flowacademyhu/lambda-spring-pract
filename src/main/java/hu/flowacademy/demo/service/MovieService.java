package hu.flowacademy.demo.service;

import hu.flowacademy.demo.model.MovieModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private Map<String, MovieModel> data = new HashMap<>();

    public List<MovieModel> findAll() {
        return data.values()
                .stream()
                .sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getTitle(), o2.getTitle()))
                .collect(Collectors.toList());
    }

    public MovieModel findById(String id) {
        return data.values().stream()
                .filter(movieModel -> id.equals(movieModel.getId()))
                .findFirst().orElse(null);
    }

    public MovieModel save(MovieModel movieModel) {
        String id = UUID.randomUUID().toString();
        MovieModel model = movieModel.toBuilder().id(id).build();
        data.put(id, model);
        return model;
    }

    public MovieModel update(String id, MovieModel movieModel) {
        data.put(id, movieModel);
        return movieModel;
    }

    public void deleteById(String id) {
        data.remove(id);
    }
}
