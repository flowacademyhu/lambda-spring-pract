package hu.flowacademy.demo.controller;

import hu.flowacademy.demo.model.MovieModel;
import hu.flowacademy.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public List<MovieModel> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movies/{id}")
    public MovieModel findById(@PathVariable String id) {
        return movieService.findById(id);
    }

    @PostMapping("/movies")
    public MovieModel save(@RequestBody MovieModel movieModel) {
        return movieService.save(movieModel);
    }

    @PutMapping("/movies/{id}")
    public MovieModel update(@PathVariable String id,
                             @RequestBody MovieModel movieModel) {
        return movieService.update(id, movieModel);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        movieService.deleteById(id);
    }
}
