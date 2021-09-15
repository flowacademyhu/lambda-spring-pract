package hu.flowacademy.demo.controller;

import hu.flowacademy.demo.model.MovieModel;
import hu.flowacademy.demo.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
//    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<MovieModel> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movies/{id}")
    public MovieModel findById(@PathVariable String id) {
        return movieService.findById(id);
    }

    @PostMapping("/movies")
    public MovieModel save(@Valid @RequestBody MovieModel movieModel, @RequestHeader("Content-Type") String contentType) {
        System.out.println(contentType);
        return movieService.save(movieModel);
    }

    @PutMapping("/movies/{id}")
    public MovieModel update(@NotNull @PathVariable String id,
                             @Valid @RequestBody MovieModel movieModel) {
        return movieService.update(id, movieModel);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        movieService.deleteById(id);
    }
}
