package hu.flowacademy.demo.service;

import hu.flowacademy.demo.config.ValidationException;
import hu.flowacademy.demo.model.MovieModel;
import hu.flowacademy.demo.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
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
//        validate(movieModel);
        return movieRepository.save(movieModel);
    }

    private void validate(MovieModel movieModel) {
        if (!StringUtils.hasText(movieModel.getTitle())) {
            throw new ValidationException("movie title is not present");
        }
        if (!StringUtils.hasText(movieModel.getDirectorName())) {
            throw new ValidationException("movie director name is not present");
        }
        if (movieModel.getReleasedAt() == null) {
            throw new ValidationException("movie released at is not present");
        }
    }

    public MovieModel update(String id, MovieModel movieModel) {
//        validate(movieModel);
        return movieRepository.update(id, movieModel);
    }

    public void deleteById(String id) {
        movieRepository.deleteById(id);
    }
}
