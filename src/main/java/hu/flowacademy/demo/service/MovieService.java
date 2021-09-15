package hu.flowacademy.demo.service;

import hu.flowacademy.demo.model.MovieModel;
import hu.flowacademy.demo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieModel> findAll() {
        return movieRepository.findAll();
    }

    public MovieModel findById(String id) {
        return movieRepository.findById(id);
    }

    public MovieModel save(MovieModel movieModel) {
        return movieRepository.save(movieModel);
    }

    public MovieModel update(String id, MovieModel movieModel) {
        return movieRepository.update(id, movieModel);
    }

    public void deleteById(String id) {
        movieRepository.deleteById(id);
    }
}
